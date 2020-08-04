package com.example.demojava.netty.time;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

public class TimeServer {

    public static void main(String[] args) throws InterruptedException {

        EventLoopGroup group = new NioEventLoopGroup();
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(group);
        bootstrap.channel(NioServerSocketChannel.class);
        bootstrap.localAddress(new InetSocketAddress("localhost", 9988));
        bootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
                ch.pipeline().addLast(new TimeServerHandler());
            }
        });
        ChannelFuture f = bootstrap.bind().sync();
    }
}
