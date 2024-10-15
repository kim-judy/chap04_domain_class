package com.javalab.sec06;

public class ComputerMain {
    public static void main(String[] args) {
        Computer myCom = new Computer();

        int result1 = myCom.sum(1, 2, 3);
        System.out.println(result1);

        int[] values = {1, 2, 3, 4, 5};
        int result3 = myCom.sum(values);
        System.out.println(result3);
    }
}
