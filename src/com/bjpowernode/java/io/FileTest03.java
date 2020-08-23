package com.bjpowernode.java.io;

import java.io.File;

/*
File中的liseFiles方法
 */
public class FileTest03 {
    public static void main(String[] args) {
        //File[] listFiles
        //获取当前目录下所有的子文件
        File f = new File("F:\\答疑");
        File[] files = f.listFiles();

        for(File file: files) {
            System.out.println(file.getAbsolutePath());
        }
    }
}
