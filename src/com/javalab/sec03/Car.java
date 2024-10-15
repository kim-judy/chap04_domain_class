package com.javalab.sec03;

//this() :생성자에서 다른 생성자를 호출하는 키워드 생성자 체이닝
//생성자 안에서 다른 생성자를 호출할때 사용
//코드 중복을 줄이기 위함
//생성자에서 맨 첫줄에 위치해야 한다


public class Car {
    String company = "현대";
    String model;
    String color;
    int speed;

    public Car() {
    }

    public Car(String model) {
        //this.model = model;
        this(model, "검정", 250);
    }

    public Car(String model, String color) {
//    this.model = model;
//    this.color = color;
        this(model, "검정", 250);
    }

    public Car(String model, String color, int speed) {
        this.model = model;
        this.color = color;
        this.speed = speed;
    }

    public void carInfo() {
        System.out.println(this.company);
        System.out.println(this.model);
        System.out.println(this.color);
        System.out.println(this.speed);
    }
}

