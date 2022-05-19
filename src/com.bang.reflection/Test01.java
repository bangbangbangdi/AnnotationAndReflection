package com.bang.reflection;

public class Test01 {
    public static void main(String[] args) throws ClassNotFoundException {
        Person person = new Student();
        System.out.println("这个人是" + person.name);

        // 通过对象获得Class
        Class c1 = person.getClass();
        System.out.println(c1.hashCode());

        // 通过forName获得
        Class c2 = Class.forName("com.bang.reflection.Student");
        System.out.println(c2.hashCode());

        // 通过类名直接获得
        Class<Student> c3 = Student.class;
        System.out.println(c3.hashCode());
    }
}

class Person{
    public String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }
}

class Student extends Person{
    public Student() {
        this.name = "Student";
    }
}

class Teacher extends Person{
    public Teacher() {
        this.name = "Teacher";
    }
}
