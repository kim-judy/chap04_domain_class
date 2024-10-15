package com.javalab.sec04;

//학생정보를 서장하는 클래스

public class Student {

    String name;
    int age;
    String major;

    public Student(String name, int age, String major) {
        this.name = name;
        this.age = age;
        this.major = major;
    }

    public Student() {
        this("judy", 20, "class");

    }

    public Student(String name, int age) {
        this(name, age, "class");
    }

    //학생 정보 출력 메소드(studentInfo)
    public void studentInfo() {
        System.out.println(name + age + major);
    }
}
