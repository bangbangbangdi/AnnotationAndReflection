package com.bang.reflection;

import java.lang.annotation.*;
import java.lang.reflect.Field;

public class Test04 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class c1 = Class.forName("com.bang.reflection.Student2");

        Annotation[] annotations = c1.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

        TableBang annotation =(TableBang) c1.getAnnotation(TableBang.class);
        System.out.println(annotation.value());

        Field f = c1.getDeclaredField("id");
        FieldBang annotation1 = f.getAnnotation(FieldBang.class);
        System.out.println(annotation1.columnName());
        System.out.println(annotation1.type());
        System.out.println(annotation1.length());
    }
}

@TableBang("db_student")
class Student2 {
    @FieldBang(columnName = "db_id", type = "int", length = 10)
    private int id;
    @FieldBang(columnName = "db_age", type = "int", length = 10)
    private int age;
    @FieldBang(columnName = "db_name", type = "varchar", length = 3)
    private String name;

    public Student2() {
    }

    public Student2(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student2{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface TableBang {
    String value();
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FieldBang {
    String columnName();

    String type();

    int length();
}