package com.example.demojava.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpServer {

    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(8888);
        byte[] bytes = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bytes,bytes.length);
        datagramSocket.receive(dp);
        byte[] data = dp.getData();;
        String string = new String(data, 0,dp.getLength());
        System.out.println(string);
    }
}
