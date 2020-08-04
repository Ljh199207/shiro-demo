package com.example.demojava.netty.time;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class TimeServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        final ByteBuf time = ctx.alloc().buffer(4);
        time.writeInt((int) (System.currentTimeMillis() / 1000L + 2208988800L));
        Integer intValue = (int) (System.currentTimeMillis() / 1000L + 2208988800L);
        byte[] bytes = int2Bytes(intValue);
      //  final ChannelFuture f = ctx.writeAndFlush(bytes);
        for (int i = 1; i <= bytes.length; i++) {
            System.out.println("发送第" + i + "次");
            final ByteBuf te = ctx.alloc().buffer(1);
            te.writeBytes(bytes, i, 1);
            ctx.writeAndFlush(te);
            try {
                // 通过sleep模拟发送不完整数据
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
     /*   f.addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture future) {
                assert f == future;
                ctx.close();
            }
        });*/
    }

    private static byte[] int2Bytes(Integer num) {
        byte[] bytes = new byte[4];
        // 通过移位运算，截取低8位的方式，将int保存到byte数组
        bytes[0] = (byte) (num >>> 24);
        bytes[1] = (byte) (num >>> 16);
        bytes[2] = (byte) (num >>> 8);
        bytes[3] = (byte) (num & 0xFF);
        return bytes;
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
