package com.javalab.sec14;

public class PersonMain {
    public static void main(String[] args) {
        // Person 객체 생성(person:참조변수)
        Person person = new Person();
        //person.name = "Jun"; // error: name has private access in Person
        // Setter를 이용하여 이름 설정
        person.setName("Jun");
        // Getter를 이용하여 이름 출력
        System.out.println(person.getName());
    }
}
