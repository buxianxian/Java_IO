package com.bjpowernode.java.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
使用FileWriter和FileReader进行拷贝的话，只能拷贝普通文本文件
java文件是普通文件
能用记事本编辑的都是普通文本文件
 */
public class Copy02 {
    public static void main(String[] args) {
        FileWriter out = null;
        FileReader in = null;

        try {
            in = new FileReader("src/com/bjpowernode/java/io/Copy02.java");
            out = new FileWriter("Copy02.java");

            //一边读一边写
            char[] chars = new char[1024 * 512]; //1MB char中一个字符是两个字节
            int readCount = 0;
            while ((readCount = in.read(chars)) != -1) {
                out.write(chars, 0, readCount);
            }
            //刷新
            out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
