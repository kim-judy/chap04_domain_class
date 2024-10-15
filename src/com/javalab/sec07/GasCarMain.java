package com.javalab.sec07;

public class GasCarMain {
    public static void main(String[] args) {
        GasCar myCar = new GasCar();

        myCar.setGas(5);

        if (myCar.isLeftGas()) {
            System.out.println("run");

            //리턴값이 없는 run() 메소드 호출
            myCar.run();
        }
        System.out.println("more gas");
    }
}
