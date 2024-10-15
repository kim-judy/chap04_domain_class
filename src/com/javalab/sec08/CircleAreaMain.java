package com.javalab.sec08;

public class CircleAreaMain {
    public static void main(String[] args) {
        CircleArea circle = new CircleArea();
        double area = circle.calculateArea(5.0);
        System.out.println(area);

        CircleArea circle2 = new CircleArea();
        double area2 = circle2.calculateArea(10.0);
        System.out.println(area2);
    }
}
