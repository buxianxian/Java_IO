package com.bjpowernode.java.io;

import java.util.Properties;

/*
目前只需要掌握Properties属性类对象的相关方法即可
Properties是一个Map集合，继承HashTable，Properties的Key和Value都是String类型
Properties被称为属性类对象
Properties是线程安全的
 */
public class PropertiesTest01 {
    public static void main(String[] args) {
        //创建一个Properties对象
        Properties pro = new Properties();
        //需要掌握Properties两个方法，一个存，一个取
        pro.setProperty("zhangsan", "shiyan");
        pro.setProperty("jiangshushu", "qiqihaerdaxue");
        pro.setProperty("xiaoxu", "heihexueyuan");

        //通过key获取value
        String a = pro.getProperty("zhangsan");
        String b = pro.getProperty("jiangshushu");
        String c = pro.getProperty("xiaoxu");

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}
