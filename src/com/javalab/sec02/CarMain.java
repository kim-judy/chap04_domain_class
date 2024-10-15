package com.javalab.sec02;

public class CarMain {
    public static void main(String[] args) {
        //기본값으로 성정되는 Car 객체 생성(빈객체)
        //생성자가 하나도 없으면 컴파일러가 자동으로 생성자를 만들어줌
        Car myCar = new Car();
        myCar.company = "현대자동차";
        myCar.model = "그랜져";
        myCar.color = "검정색";
        myCar.price = 3000;
        myCar.speed = 100;

        System.out.println("company : " + myCar.company);
        System.out.println("model : " + myCar.model);
        System.out.println("color : " + myCar.color);
        System.out.println("price : " + myCar.price);
        System.out.println("speed : " + myCar.speed);


        Car car2 = new Car("기아자동차");
        System.out.println(car2.company);

        Car car3 = new Car("기아자동차", "k5", "red", 2000, 200);
        System.out.println(car3.company);

        Car car4 = new Car("현대자동차", "k3", "red", 2000, 200);
        car4.carInfo();
    }


}
