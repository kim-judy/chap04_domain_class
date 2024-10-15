package com.javalab.sec05;

public class CalculatorMain {
    public static void main(String[] args) {
        // Calculator 객체 생성
        Calculator myCalc = new Calculator();
        // 전원 켜기
        myCalc.powerOn();
        // 덧셈연산
        int result1 = myCalc.plus(5, 6);
        System.out.println("result1: " + result1);
        // 나눗셈연산
        int x = 10;
        int y = 4;
        double result2 = myCalc.divide(x, y);
        System.out.println("result2: " + result2);

    }

}
