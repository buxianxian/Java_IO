package com.bjpowernode.java.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
int read(byte b[])
一次最多读取b.length个字节
减少硬盘和内存的交互，提高程序的执行效率
往byte[]数组中读
 */
public class FileInputStreamTest03 {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            //相对路径的话呢？相对路径一定是从当前所在的位置作为起点开始找
            //IDEA默认的当前路径是哪里？工程Project的根就是IDEA默认的当前路径
            //fis = new FileInputStream("tempfile");
            //fis = new FileInputStream("src/tempfile2");
            fis = new FileInputStream("src/com/bjpowernode/java/io/tempfile3");

            //开始读，采用byte数组，一次读取多个字节。最多读取数组.length个字节
            byte[] bytes = new byte[4]; //准备一个四个长度的byte数组，一次最多读取4个字节
            //这个方法的返回值是：读取到的的字节数量（不是字节本身）
            int readCount = fis.read(bytes);
            System.out.println(readCount); //第一次读到了4个字节
            //将字节数组全部转换成字符串
            //System.out.println(new String(bytes)); //abcd
            //不应该全部转换，应该是读取了多少个字节，转换多少个
            System.out.println(new String(bytes, 0, readCount));

            readCount = fis.read(bytes); //第二次只能读取到2个字节
            System.out.println(readCount); //2
            //将字节数组全部转换成字符串
            //System.out.println(new String(bytes)); //efcd
            //不应该全部转换，应该是读取了多少个字节，转换多少个
            System.out.println(new String(bytes, 0, readCount));

            readCount = fis.read(bytes); //1个字节都没有读取到，返回-1
            System.out.println(readCount); //-1

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
