package com.xlm.reactor;

import java.io.IOException;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.*;

/**
 * @author xls
 * @date 2019-05-14
 * @description Acceptor
 */
public class Acceptor implements Runnable {
    private final ExecutorService executorService = new ThreadPoolExecutor(
            10,
            20,
            0L,
            TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(1024),new ThreadPoolExecutor.AbortPolicy());
    private final ServerSocketChannel serverSocketChannel;
    public Acceptor(ServerSocketChannel serverSocketChannel) {
        this.serverSocketChannel = serverSocketChannel;
    }

    @Override
    public void run() {
        try {
            //获取客户端链接
            SocketChannel channel = serverSocketChannel.accept();
            if (null != channel) {
                executorService.execute(new Handler(channel));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
