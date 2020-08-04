package com.example.demojava.netty.tcp;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

public class ClientHandler extends SimpleChannelInboundHandler {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("Client received: " + msg.toString());

    }

    @Override
    public void channelActive(ChannelHandlerContext channelHandlerContext) {
        channelHandlerContext.writeAndFlush(Unpooled.copiedBuffer("Netty Rocks!", CharsetUtil.UTF_8));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable cause) {
        cause.printStackTrace();
        channelHandlerContext.close();
    }
}
