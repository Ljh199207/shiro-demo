package com.example.demojava.netty.tcp;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

public class TcpClient {

    public static void main(String[] args) throws InterruptedException {
        // 创建EventLoopGroup
        EventLoopGroup group = new NioEventLoopGroup();
        //创建并配置Bootstrap
        Bootstrap clientBootstrap = new Bootstrap();
        clientBootstrap.group(group);
        clientBootstrap.channel(NioSocketChannel.class);
        clientBootstrap.remoteAddress(new InetSocketAddress("localhost", 9999));
        //创建ChannelInitializer
        clientBootstrap.handler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
                ch.pipeline().addLast(new ClientHandler());
            }
        });
        //启动
        ChannelFuture channelFuture = clientBootstrap.connect().sync();
        // 关闭
        channelFuture.channel().closeFuture().sync();
    }
}
