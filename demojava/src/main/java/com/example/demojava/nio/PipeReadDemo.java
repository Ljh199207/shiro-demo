package com.example.demojava.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

public class PipeReadDemo {

    public static void main(String[] args) throws IOException {

        Pipe pipe = Pipe.open();

        //写入数据到pipe
        Pipe.SourceChannel source = pipe.source();

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        int bytesRead = source.read(buffer);

    }
}
