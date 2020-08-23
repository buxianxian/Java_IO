package com.bjpowernode.java.io;

import java.io.FileOutputStream;
import java.io.PrintStream;

/*
PrintStream：标准的字节输出流，默认输出到控制台
 */
public class PrintStreamTest {
    public static void main(String[] args) throws Exception {
        //联合起来写
        System.out.println("hello world");

        //分开写
        PrintStream ps = System.out;
        ps.println("欢迎来到王者荣耀");

        //标准输出流不需要手动close关闭

        //标准输出流不再指向控制台，指向log文件
        PrintStream printStream = new PrintStream(new FileOutputStream("log"));
        //修改输出方向，将输出方向修改到log文件
        System.setOut(printStream);
        //再输出
        System.out.println("欢迎来到王者荣耀");
        System.out.println("你的段位是永恒钻石");

    }
}
