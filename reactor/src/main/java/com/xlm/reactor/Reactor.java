package com.xlm.reactor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author xls
 * @date 2019-05-14
 * @description reactor
 */
public class Reactor implements Runnable{
    private final Selector selector;
    private final ServerSocketChannel serverSocket;

    public Reactor(int port) throws IOException {
        //创建服务端ServerSocketChannel
        serverSocket = ServerSocketChannel.open();
        //设置为非阻塞模式
        serverSocket.configureBlocking(Boolean.FALSE);
        //创建一个Selector多路复用器
        selector = Selector.open();
        SelectionKey key = serverSocket.register(selector, SelectionKey.OP_ACCEPT);
        //绑定服务端口
        serverSocket.bind(new InetSocketAddress(port));
        //为channel绑定acceptor
        key.attach(new Acceptor(serverSocket));
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                //服务端使用一个线程不断等待客户端的链接到达
                selector.select();
                Set<SelectionKey> keys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = keys.iterator();
                while (iterator.hasNext()) {
                    dispatch(iterator.next());
                    iterator.remove();
                }
                selector.selectNow();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void dispatch(SelectionKey selectionKey) {
        //这里的attachment也就是前面为服务端channel绑定的acceptor,调用其run()进行客户端链接的获取,并且进行分发
        Runnable attachment = (Runnable) selectionKey.attachment();
        new Thread(attachment).start();
    }
}
