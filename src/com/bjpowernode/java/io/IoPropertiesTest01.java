package com.bjpowernode.java.io;

import java.io.FileReader;
import java.util.Properties;

/*
IO和Properties的联合应用
非常好的一个设计理念：
    以后经常改变的数据，可以单独写到一个文件当中，使用程序动态读取
    将来之需要修改这个文件的内容，java代码不需要改动，不需要重新编译，
    服务器也不需要重启，就可以拿到动态的信息。

    类似于以上机制的这种文件被称为配置文件。
    并且当配置文件中的内容格式是：
        key1=value
        key2=value
    的时候，我们把这种配置文件叫做属性配置文件。

    java规范中有要求：属性配置文件建议以.properties结尾，但这不是必须的。
    这种以.properties结尾的文件在java中被称为：属性配置文件
    其中Properties是专门存放属性配置文件内容的一个类
 */
public class IoPropertiesTest01 {
    public static void main(String[] args) throws Exception {
        /*
        Properties是一个Map集合，继承HashTable，Properties的Key和Value都是String类型
        想将userinfo文件中的数据加载到Properties对象中
         */
        //新建一个输入流对象
        FileReader reader = new FileReader("userinfo.properties");

        //新建一个Map集合
        Properties pro = new Properties();

        //调用Properties对象的load方法将文件中的数据加载到Map集合中
        pro.load(reader); //文件中的数据顺着管道加载到Map集合中，其中等号=左边做key，右边做value

        //通过key来获取value
        String username = pro.getProperty("username");
        System.out.println(username);

    }
}
