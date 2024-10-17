package com.javalab.sec16;

/**
 * 학생 클래스
 * - 학생의 정보를 저장하는 클래스
 * - 필드는 학생명, 나이, 성별, 연락처, 점수(성적)
 * - 생성자, Getter, Setter
 * - showStudent 메소드 구현하여 객체 정보 출력
 */
public class Student {
    // 필드 선언
    private String name;  // 학생명
    private int age;  // 나이
    private char gender;  // 성별
    private String phone;  // 연락처
    private int score;  // 점수(성적)

    // 생성자
    public Student() {
    }

    // 오버로딩 생성자(전체 필드를 초기화해주는 생성자)
    public Student(String name, int age, char gender, String phone, int score) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.score = score;
    }
    // Getter, Setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    // showStudent 메소드 구현하여 객체 정보 출력
    public void showStudent() {
        System.out.println("학생명: " + name);
        System.out.println("나이: " + age);
        System.out.println("성별: " + gender);
        System.out.println("연락처: " + phone);
        System.out.println("점수: " + score);
    }
}
