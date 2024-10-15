package com.javalab.package1;

import com.javalab.package1.package2.C;

public class A {
    // B 클래스를 필드로 갖음
    B b;
    C c;

    // 필드 선언
    A a1 = new A(true);
    A a2 = new A(1);
    A a3 = new A("문자열");

    // 추가 필드 선언(접근제한테스트)
    public int field1;
    int field2;
    private int field3;

    // 추가 메소드(접근제한테스트)
    public void method1() {
    }

    void method2() {
    }

    private void method3() {
    }


    // public 생성자 - 다른 패키지의 클래스에서 접근 가능
    public A(boolean b) {
    }

    // default 접근제한 생성자 - 같은 패키지의 클래스에서 접근 가능
    A(int a) {
    }

    // private 접근제한 생성자 - 같은 클래스 내에서만 접근 가능
    private A(String s) {
    }

}
