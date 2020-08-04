package com.example.demojava.netty.tcp;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

public class TcpServer {

    public static void main(String[] args) throws InterruptedException {
        //1 创建EventLoopGroup
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        //2 创建ServerBootstrap

        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(eventLoopGroup);
        bootstrap.channel(NioServerSocketChannel.class);
        bootstrap.localAddress(new InetSocketAddress("localhost", 9999));

        //3 创建ChannelInitializer
        bootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel socketChannel) throws Exception {
                socketChannel.pipeline().addLast(new HelloServerHandler());
            }
        });

        //4 启动
        ChannelFuture channelFuture = bootstrap.bind().sync();
    }
}
