package com.bjpowernode.java.io;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/*
反序列化
 */
public class ObjectInputStreamTest01 {
    public static void main(String[] args) throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student"));
        //开始反序列化，读
        Object obj = ois.readObject();
        //反序列化回来是一个学生对象，所以会调用学生对象的toString方法
        System.out.println(obj);
        ois.close();
    }
}
