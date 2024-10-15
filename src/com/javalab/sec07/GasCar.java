package com.javalab.sec07;

//가스가 남아있는지 확인하는 메소드
//리턴값이 boolean인 메소드, gas 필드값이 0이면 false를, 0이 아니면 true를 리턴

public class GasCar {
    //필드 선언(속성, 멤버변수)
    int gas;

    //생성자 호출
    public GasCar() {
        gas = 0;
    }

    void setGas(int gas) {
        this.gas = gas;
    }

    boolean isLeftGas() {
        if (gas == 0) {
            System.out.println("no gas");
            return false;
        }
        System.out.println("gas");
        return true;
    }

    void run() {
        while (true) {
            if (gas > 0) {
                System.out.println("달립니다." + gas + "");
                gas -= 1;
            } else {
                System.out.println("멈춥니다" + gas + "");
                return;
            }
        }
    }
}
