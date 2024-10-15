package com.javalab.sec02;

public class Car {
    String company;
    String model;
    String color;
    int price;
    int speed;

    //역할은 객체 생성시 필드(속성)값을 초기화
    public Car() {
        System.out.println("Car 생성자");
    }

    //또다른 생성자
    //외부에서 전달한 값으로 제조사만 초기화
    public Car(String company) {
        this.company = company;
    }
//
//    public Car(String company, String model) {
//        this.company = company;
//        this.model = model;
//    }

    public Car(String company, String model, String color, int price, int speed) {
        this.company = company;
        this.model = model;
        this.color = color;
        this.price = price;
        this.speed = speed;
    }

    public void carInfo() {
        System.out.println(this.company);
        System.out.println(this.model);
        System.out.println(this.color);
        System.out.println(this.price);
        System.out.println(this.speed);
    }
}
