package com.example.demojava.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class DatagramChannelDemo {

    public static void main(String[] args) throws IOException {
        DatagramChannel channel = DatagramChannel.open();
        channel.socket().bind(new InetSocketAddress(9999));

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        byte b[];

        while (true) {
            buffer.clear();
            SocketAddress socketAddress = channel.receive(buffer);
            if (socketAddress != null) {
                int position = buffer.position();
                b = new byte[position];
                buffer.flip();
                for (int i = 0; i < position; ++i) {
                    b[i] = buffer.get();
                }
                System.out.println("receive remote " + socketAddress.toString() + ":" + new String(b, "UTF-8"));
                SendReback(socketAddress, channel);
            }
        }
    }

    public static void SendReback(SocketAddress socketAddress, DatagramChannel datagramChannel) throws IOException {
        String message = "I has receive your message";
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put(message.getBytes("UTF-8"));
        buffer.flip();
        datagramChannel.send(buffer, socketAddress);
    }
}
