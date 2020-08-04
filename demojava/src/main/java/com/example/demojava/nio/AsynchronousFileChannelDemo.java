package com.example.demojava.nio;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class AsynchronousFileChannelDemo {

    public static void main(String[] args) throws IOException {

     /*   Path p = new ClassPathResource("data/fromFile.txt").getFile().toPath();

        AsynchronousFileChannel asynchronousFileChannel = AsynchronousFileChannel.open(p, StandardOpenOption.READ);

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        long position = 0;
*//*
        Future<Integer> operation = asynchronousFileChannel.read(buffer, position);

        while (!operation.isDone()) ;
        buffer.flip();
        byte[] data = new byte[buffer.limit()];
        buffer.get(data);
        System.out.println(new String(data));
        buffer.clear();*//*
        asynchronousFileChannel.read(buffer, position, buffer, new CompletionHandler<Integer, ByteBuffer>() {
            @Override
            public void completed(Integer result, ByteBuffer attachment) {
                System.out.println("result = " + result);
                attachment.flip();
                byte[] data = new byte[attachment.limit()];
                attachment.get(data);
                System.out.println(new String(data));
                attachment.clear();
            }

            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {

                System.out.println("error");
            }
        });
*/
  /*      Path path = new ClassPathResource("data/fromFile.txt").getFile().toPath();
        AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(path, StandardOpenOption.WRITE);

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        long position = 0;

        buffer.put("test data".getBytes());
        buffer.flip();

        Future<Integer> operation = fileChannel.write(buffer, position);
        buffer.clear();

        while(!operation.isDone());

        System.out.println("Write done");*/

        Path path = new ClassPathResource("data/fromFile.txt").getFile().toPath();
        if(!Files.exists(path)){
            Files.createFile(path);
        }
        AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(path, StandardOpenOption.WRITE);

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        long position = 0;

        buffer.put("test data".getBytes());
        buffer.flip();

        fileChannel.write(buffer, position, buffer, new CompletionHandler<Integer, ByteBuffer>() {

            @Override
            public void completed(Integer result, ByteBuffer attachment) {
                System.out.println("bytes written: " + result);
            }

            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {
                System.out.println("Write failed");
                exc.printStackTrace();
            }
        });


    }
}
