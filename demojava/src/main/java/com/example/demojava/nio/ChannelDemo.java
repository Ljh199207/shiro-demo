package com.example.demojava.nio;

import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;

public class ChannelDemo {

    public static void main(String[] args) throws IOException {

        File file = new ClassPathResource("data/nio-data.txt").getFile();
        Path path  = file.toPath();

        // 构建随机访问可读写的文件对象
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        FileInputStream  fileInputStream  = new FileInputStream(new ClassPathResource("data/nio-data.txt").getFile());



        // 获取文件通道
        FileChannel inChannel = fileInputStream.getChannel();
        // 分配缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(48);
        // 将通道数据读入到缓冲区
        int bytesRead = inChannel.read(buffer);

        while (bytesRead != -1) {
            buffer.flip();
            // 如果缓冲区还有剩余数据
            while (buffer.hasRemaining()) {
                // 获取并打印
                System.out.print((char) buffer.get());
            }
            // 将position=0，limit=capacity
            buffer.clear();
            // 再次读入数据到缓冲区，进入下一个循环
            bytesRead = inChannel.read(buffer);
        }
        // 关闭文件对象
        randomAccessFile.close();
    }
}
