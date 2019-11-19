package com.example.springbootmybits.magic;

import java.io.IOException;

/**
 * @author ljh
 * @date 2019-11-19 09:49
 */
public class FileDemo {
    public static void main(String[] args) throws IOException {
        String filePath = "D:\\安装包\\MyBatis-4.6.jpg";
        FileType fileType = FileUtil.getFileType(filePath);
        System.out.println(fileType.getKey());
    }
}
