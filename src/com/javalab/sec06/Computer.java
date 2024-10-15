package com.javalab.sec06;

//가변길이 매개변수(varaars)
//메소드의 매개변수를 동적으로 지정할 수 있게 해주는 기능
//매개변수가 여러개일 경우에는 배열로 처리

public class Computer {
    public int sum(int... value) {
        int sum = 0;

        for (int i = 0; i < value.length; i++) {
            sum += value[1];

        }
        return sum;
    }
}
