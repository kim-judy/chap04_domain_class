package com.javalab.sec01;

//실행클래스
//-도메인 클래스를 객체로 생성해서 사용하는 클래스

public class HumanMain {
    public static void main(String[] args) {
        //new : 객체 생성 연산자
        //Human() 생성자를 호출해서 객체를 생성
        Human human = new Human();
        human.ssn = "12334-52352";
        human.name = "kimjudy";
        human.age = 25;


        System.out.println(human.ssn);
        System.out.println(human.name);
        System.out.println(human.age);
    }
}
