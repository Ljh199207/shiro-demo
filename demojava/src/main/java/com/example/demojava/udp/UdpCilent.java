package com.example.demojava.udp;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UdpCilent {

    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket();
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入你要发送的字符串");
        String data = scanner.nextLine();
        byte[] str = data.getBytes();
        InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
        DatagramPacket dp = new DatagramPacket(str, str.length, inetAddress, 8888);
        datagramSocket.send(dp);
    }
}
