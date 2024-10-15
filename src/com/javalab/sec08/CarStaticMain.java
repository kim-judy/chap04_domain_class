package com.javalab.sec08;

/*한 파일에 두 개의 클래스 생성*/

class Car {
    //인스턴스 변수 선언 : 각 자동차 인스턴스가 가지는 필드
    //객체로 생성해야만 사용 가능
    int speed;
    //정적 변수 선언 : 모든 자동차 인스턴스가 공유하는 필드(자동차의 갯수 추적)
    //객체 생성없이 클래스 이름으로 사용가능
    static int carCount = 0;

    //생성자 : 인스턴스 변수 초기화 및 정적 변수 값 증가
    public Car(int speed) {
        this.speed = speed;   //인스턴스 변수 초기화
        carCount++;     //자동차가 생성될 때마다 carCount 증가
    }

    //인스턴스 메소드 : 속도 증가
    public void accelerate(int amount) {
        this.speed += amount;   //인스턴스 변수 사용
    }

    //인스턴스 메소드 : 속도 출력
    public void showSpeed() {
        System.out.println("Car speed: " + this.speed + "km/h");
    }

    //정적 메소드 : 총 자동차 개수 출력
    public static void showCarCount() {
        System.out.println("Total cars : " + carCount);  //정적 변수 사용
    }
}

public class CarStaticMain {
    public static void main(String[] args) {
        //첫번째 자동차 객체 생성(속도 100)
        Car car1 = new Car(100);
        car1.showSpeed();
        Car.showCarCount();

        //첫번째 자동차 객체 생성(속도 100)
        Car car2 = new Car(150);
        car2.showSpeed();
        Car.showCarCount();

        //첫번째 자동차 속도 증가
        car1.accelerate(20);
        car1.showSpeed();
        Car.showCarCount();
    }
}

