package com.javalab.sec20;

import com.javalab.sec14.Person;

public class WrapperExample {
    public static void main(String[] args) {
        // 기본 자료형을 Wrapper 클래스로 변환(Auto Boxing)
        Integer num = 100; // 자동 박싱, Integer num = new Integer(100); 과 동일
        Double decimal = 3.14; // 자동 박싱
        System.out.println("num: " + num); // num: 100, num.toString() 과 동일

        // Wrapper 클래스를 기본 자료형으로 변환(Auto Unboxing)
        int unboxedNum = num; // 자동 언박싱, int unboxedNum = num.intValue(); 과 동일
        double unboxedDecimal = decimal; // 자동 언박싱, decimal.doubleValue(); 과 동일

        // 문자열을 기본 자료형으로 변환
        int parsedInt = Integer.parseInt("100"); // 문자열 "100"을 정수로 변환
        double parsedDouble = Double.parseDouble("3.14");

        // 문자열을 Wrapper 클래스로 변환
        Integer parsedInteger = Integer.valueOf("100"); // 문자열 "100"을 Integer 객체로 변환
        Double parsedDoubleObj = Double.valueOf("3.14");// 문자열 "3.14"를 Double 객체로 변환

        // Wrapper 클래스의 상수
        int maxInt = Integer.MAX_VALUE; // int의 최대값
        int minInt = Integer.MIN_VALUE; // int의 최소값

        // Wrapper 클래스의 상수 출력
        System.out.println("int의 최대값: " + maxInt);
        System.out.println("int의 최소값: " + minInt);


    }

}
