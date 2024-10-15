package com.javalab.sec11;

class Car {
    public String model;
    public int speed;

    public Car() {
    }

    public Car(String model, int speed) {
        this.model = model;
        this.speed = speed;
    }

    public void showSpeed() {
        System.out.println(speed);
    }

    public void changeSpeed(int speed) {
        if (speed < 0) {
            this.speed = 0;
            return;
        } else {
            this.speed = speed;
        }

    }
}


public class CarMain {
    public static void main(String[] args) {

        Car car1 = new Car(); //빈객체 생성
        //필드 초기화
        car1.model = "KIA";
        //car1.speed = 200;
        car1.changeSpeed(200);
        car1.showSpeed();

        Car car2 = new Car("BENZ", 120);
        // car2.showSpeed();
        car2.changeSpeed(-120);
    }
}
