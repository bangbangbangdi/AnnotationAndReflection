package com.bang.reflection;

public class Test02 {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(a.m);
    }
}

class A{
    static int m = 100;
    static {
        System.out.println("A类静态代码初始化");
        m = 300;
    }

    public A() {
        System.out.println("A类的无参构造方法");

    }
}
