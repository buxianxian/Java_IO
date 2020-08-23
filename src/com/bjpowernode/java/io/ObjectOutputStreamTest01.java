package com.bjpowernode.java.io;

import com.bjpowernode.java.bean.Student;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/*
1.java.io.NotSerializableException
    Student对象不支持序列化
2.参与序列化和反序列化的对象，必须实现Serializable接口
3.注意：通过源代码发现，Serializable接口只是一个标志接口
    public interface Serializable {

    }
    这个接口当中什么代码都没有
    那么它起到一个什么作用呢？
        起到标识的作用，标志的作用，java虚拟机看到这个类实现了这个接口，可能会对这个类进行特殊待遇
        Serializable这个标志接口是给java虚拟机参考的，java虚拟机看到这个接口后，会为该类自动生成
        一个序列化版本号
4.序列化版本号有什么用呢？
    java.io.InvalidClassException:
        com.bjpowernode.java.bean.Student;
                local class incompatible:
                stream classdesc serialVersionUID = -684255398724514298,（十年后）
                local class serialVersionUID = -3463447116624555755(十年前)
     java语言中是采用什么机制来区分类的？
        第一，首先通过类名进行对比，，如果类名不一样，肯定不是同一个类
        第二，如果类名一样，再怎么进行类的区分？靠序列化版本号进行区分

     小明编写了一个类：com.bjpowernode.java.bean.Student implements Serializable
     小红编写了一个类：com.bjpowernode.java.bean.Student implements Serializable
     不同的人编写了一个类，但这两个类确实不是同一个类，这个时候序列化版本就起上作用了
     对于java虚拟机来说，java虚拟机是可以区分开这两个类的，因为这两个类都实现了Serializable接口，
     都有默认的序列化版本号，他们的序列化版本号不一样，所以区分开了。（这是自动生成序列化版本号的好处）

     这种自动生成序列化版本号有什么缺陷？
        这种自动生成序列化版本号的缺点是：一旦代码确定之后，不能进行后续的修改。
        因为只要修改，必然会进行重新编译，此时会生成全新的序列化版本号，这个时候java
        虚拟机会认为这是一个全新的类（这样就不好了）

     最终结论：
        凡是一个类实现了Serializable接口，建议给该类提供一个固定不变的序列化版本号，
        这样，以后这个类即使代码修改了，但是版本号不变，java虚拟机会认为是同一个类。
 */
public class ObjectOutputStreamTest01 {
    public static void main(String[] args) throws Exception {
        Student s = new Student(1111, "zhangsan");
        //序列化
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student"));
        //序列化对象
        oos.writeObject(s);

        //刷新
        oos.flush();
        //关闭
        oos.close();
    }
}
