package com.javalab.package1.package2;

import com.javalab.package1.A;

public class C {
    public static void main(String[] args) {
        A a = new A(true);

        a.field1 = 1;
        //a.field2 = 2;
        //a.field3 = 3;

        a.method1();
        //a.method2();
        //a.method3();

    }
}
