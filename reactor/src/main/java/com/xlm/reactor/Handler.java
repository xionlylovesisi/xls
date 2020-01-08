package com.xlm.reactor;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author xls
 * @date 2019-05-14
 * @description Handler
 */
public class Handler implements Runnable {
    private final SocketChannel socketChannel;
    private volatile static Selector selector;
    private SelectionKey key;
    private volatile ByteBuffer input = ByteBuffer.allocate(1024);
    private volatile ByteBuffer output = ByteBuffer.allocate(1024);

    public Handler(SocketChannel channel) throws IOException {
        this.socketChannel = channel;
        //设置客户端链接为非阻塞模式
        channel.configureBlocking(false);
        //为客户端创建一个新的多路复用器
        selector = Selector.open();
        //注册客户端channel的读事件
        key = channel.register(selector, SelectionKey.OP_READ);
    }

    @Override
    public void run() {
        try {
            while (selector.isOpen() && socketChannel.isOpen()) {
                //等待客户端事件发生
                Set<SelectionKey> keys = select();
                Iterator<SelectionKey> iterator = keys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    iterator.remove();
                    //当前是读事件
                    if (key.isReadable()) {
                        read(key);
                    } else if (key.isWritable()) {
                        //当前是写事件
                        write(key);
                    }

                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void write(SelectionKey key) throws IOException {
        output.flip();
        if (socketChannel.isOpen()) {
            //当有写入事件时,将业务处理的结果写入到客户端channel中
            socketChannel.write(output);
            key.channel();
            socketChannel.close();
            output.clear();
        }
    }

    /**
     * 读取客户端发送的数据
     *
     * @param key
     */
    private void read(SelectionKey key) throws IOException {
        socketChannel.read(input);
        if (input.position() == 0) {
            return;
        }
        input.flip();
        //业务处理
        process();
        input.clear();
        //读取完成后监听写入事件
        key.interestOps(SelectionKey.OP_WRITE);
    }

    private void process() throws UnsupportedEncodingException {
        //进行业务处理,并获取处理结果,本质上,基于reactor模型,如果这里成为瓶颈,则直接将处理过程放入线程池即可
        //并使用future获取处理结果,最后写入客户端channel
        byte[] bytes = new byte[input.remaining()];
        input.get(bytes);
        String message = new String(bytes, "UTF-8");
        System.out.println("receive message from client: /n" + message);
        output.put("hello client".getBytes());
    }

    private Set<SelectionKey> select() throws IOException {
        //这里处理的主要目的是处理jdk的一个bug,该bug会导致selector被意外触发,但实际上没有任何事件到达
        //此时的处理方式是新建一个selector,然后重新将当前的channel注册到该selector上
        selector.select();
        Set<SelectionKey> keys = selector.selectedKeys();
        if (keys.isEmpty()) {
            int interestOps = key.interestOps();
            selector = Selector.open();
            socketChannel.register(selector, interestOps);
            return select();
        }
        return keys;
    }
}
