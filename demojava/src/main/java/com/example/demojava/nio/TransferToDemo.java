package com.example.demojava.nio;

import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class TransferToDemo {

    public static void main(String[] args) throws IOException {
        File file = new ClassPathResource("data/fromFile.txt").getFile();

        RandomAccessFile fromFile = new RandomAccessFile(file, "rw");
        FileChannel fromChannel = fromFile.getChannel();

        File file1 = new ClassPathResource("data/toFile.txt").getFile();
        RandomAccessFile toFile = new RandomAccessFile(file1, "rw");
        FileChannel      toChannel = toFile.getChannel();

        long position = 0;
        long count    = fromChannel.size();
        //
        fromChannel.transferTo(position, count, toChannel);

        // 分配缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(48);
        // 将通道数据读入到缓冲区
        int bytesRead = toChannel.read(buffer);

        while (bytesRead != -1) {
            buffer.flip();
            // 如果缓冲区还有剩余数据
            System.out.print("to---");
            while (buffer.hasRemaining()) {
                // 获取并打印
                System.out.print((char) buffer.get());
            }
            // 将position=0，limit=capacity
            buffer.clear();
            // 再次读入数据到缓冲区，进入下一个循环
            bytesRead = toChannel.read(buffer);
        }

        // 分配缓冲区
        ByteBuffer buffer1 = ByteBuffer.allocate(48);
        buffer1.rewind();
        // 将通道数据读入到缓冲区
        int bytesRead1 = fromChannel.read(buffer1);

        while (bytesRead1 != -1) {
            buffer1.flip();
            // 如果缓冲区还有剩余数据
            System.out.print("from---");
            while (buffer1.hasRemaining()) {
                // 获取并打印
                System.out.print((char) buffer1.get());
            }
            // 将position=0，limit=capacity
            buffer1.clear();
            // 再次读入数据到缓冲区，进入下一个循环
            bytesRead1 = fromChannel.read(buffer1);
        }

    }
}
