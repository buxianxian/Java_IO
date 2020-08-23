package com.bjpowernode.java.io;

import java.io.FileWriter;
import java.io.IOException;

/*
FileWriter
    文件字符输出流，写
    只能输出普通文本
 */
public class FileWriterTest {
    public static void main(String[] args) {
        FileWriter out = null;
        try {
            out = new FileWriter("file");

            //开始写,写的时候会先把原文件清空掉
            //out = new FileWriter("file", true); 就不会清空
            char[] chars = {'欢', '迎', '来', '到', '王', '者', '荣', '耀'};
            out.write(chars);
            out.write(chars, 2, 3);
            out.write("我的段位是至尊星耀");
            out.write("\n");
            out.write("hello world");
            //刷新
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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
