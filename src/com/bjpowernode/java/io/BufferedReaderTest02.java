package com.bjpowernode.java.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/*
InputStreamReader：转换流
 */
public class BufferedReaderTest02 {
    public static void main(String[] args) throws Exception {
        //字节流
        FileInputStream in = new FileInputStream("Copy02.java");

        //通过转换流转换（InputStreamReader将字节流转换为字符流）
        //in是节点流，reader是包装流
        InputStreamReader reader = new InputStreamReader(in);

        //这个构造方法只能传一个字符流，不能传字节流
        //reader是节点流，br是包装流
        BufferedReader br = new BufferedReader(reader);

        String line = null;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

        //关闭最外层
        br.close();

    }
}
