package com.example.demojava.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

public class PipeDemo {

    public static void main(String[] args) throws IOException {

       /* Pipe pipe = Pipe.open();

        //写入数据到pipe
        Pipe.SinkChannel sinkChannel = pipe.sink();

        String newData = "New String to write to file..." + System.currentTimeMillis();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.clear();
        buffer.put(newData.getBytes("UTF-8"));
        buffer.flip();
        while (buffer.hasRemaining()) {
            sinkChannel.write(buffer);
        }
        */

        // 1. 获取管道
        Pipe pipe = Pipe.open();

        // 2. 将缓冲区数据写入到管道
        // 2.1 获取一个通道
        Pipe.SinkChannel sinkChannel = pipe.sink();
        // 2.2 定义缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(48);
        buffer.put("发送数据".getBytes());
        buffer.flip(); // 切换数据模式
        // 2.3 将数据写入到管道
        sinkChannel.write(buffer);

        // 3. 从管道读取数据
        Pipe.SourceChannel sourceChannel = pipe.source();
        buffer.flip();
        int len = sourceChannel.read(buffer);
        System.out.println(new String(buffer.array(), 0, len));

        // 4. 关闭管道
        sinkChannel.close();
        sourceChannel.close();


    }
}
