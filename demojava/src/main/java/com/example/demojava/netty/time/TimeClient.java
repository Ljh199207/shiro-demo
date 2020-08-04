package com.example.demojava.netty.time;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

public class TimeClient {

    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup eventExecutors = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        try {
            bootstrap.group(eventExecutors);
            bootstrap.channel(NioSocketChannel.class);
            bootstrap.remoteAddress(new InetSocketAddress("localhost", 9988));
            bootstrap.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new TimeDecoder(),new TimeClientHandler());
                }
            });
            ChannelFuture f = bootstrap.connect().sync();

            // 等待连接关闭
            f.channel().closeFuture().sync();
        } finally {
            eventExecutors.shutdownGracefully();
        }

    }
}
