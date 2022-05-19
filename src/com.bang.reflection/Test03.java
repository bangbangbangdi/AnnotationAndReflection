package com.bang.reflection;

public class Test03 {
    static{
        System.out.println("Main类被加载了");
    }
    public static void main(String[] args) throws ClassNotFoundException {
        // 主动引用
//        Son son = new Son();

        // 反射也会产生主动引用
//        Class.forName("com.bang.reflection.Son");

        // 不会产生主动引用的方法
//        System.out.println(Son.b);

        System.out.println(Son.m);
    }
}

class Father{
    static int b = 2;

    static{
        System.out.println("父类被加载");
    }
}

class Son extends Father{

    static {
        System.out.println("子类被加载");
        m = 300;
    }
    static int m = 100;
    static final int M = 1;
}