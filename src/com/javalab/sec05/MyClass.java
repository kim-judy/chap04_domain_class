package com.javalab.sec05;

public class MyClass {
    public void methodA() {
        System.out.println("methodA() 호출됨 ...");
    }

    public void methodB() {
        System.out.println("methodB() 호출됨 ...");
        methodA();
    }

    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        myClass.methodB();
    }
}
