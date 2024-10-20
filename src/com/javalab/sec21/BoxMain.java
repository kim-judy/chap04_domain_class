package com.javalab.sec21;

import com.javalab.sec18.Employee;

/**
 * Box 클래스
 * - 제네릭 클래스로서 어떤 타입의 객체도 저장할 수 있는 상자
 * - T : 타입 파라미터
 * - Box<T> : 제네릭 클래스 Box는 객체 생성 시 타입 파라미터 T를 받아들이는 클래스
 */
class Box<T> {
    // 필드 선언 - 제네릭 타입 T로 선언
    private T item;
    // 세터메소드
    public void setItem(T item) {
        this.item = item;
    }
    // 게터메소드
    public T getItem() {
        return item;
    }
    // toString 메소드 - Box 객체가 가지고 있는 item 객체의 내용물을 보여줌.
    /*
    public String toString() {
        return "Box contains: " + item.toString();
    }
    */
}

class Product{
    // 필드 선언
    private int productId;
    private String name;

    public Product() {
    }
    // 생성자
    public Product(int productId, String name) {
        this.productId = productId;
        this.name = name;
    }
    // 게터메소드
    public int getProductId() {
        return productId;
    }
    // 세터메소드
    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void showProduct(){
        System.out.println("productId : " + productId);
        System.out.println("name : " + name);
    }
    public String toString() {
        return "Product [productId=" + productId + ", name=" + name + "]";
    }
}

public class BoxMain {
    public static void main(String[] args) {
        // String 타입의 Box 객체 생성
        Box<String> box1 = new Box<String>();
        box1.setItem("Hello, World!");
        System.out.println("Box contains: " + box1.getItem());

        // Integer 타입의 Box 객체 생성
        Box<Integer> box2 = new Box<Integer>();
        box2.setItem(123);
        System.out.println("Box contains: " + box2.getItem());

        // Product 타입의 Box 객체 생성
        Box<Product> box3 = new Box<Product>(); // Product 타입의 객체를 저장할 수 있는 Box 객체 생성
        Product product = new Product(100, "Notebook");
        box3.setItem(product);// Product 객체를 Box 객체에 저장
        System.out.println("Box contains: " + box3.getItem());

        // Employee 타입의 Box 객체 생성
        Box<Employee> box4 = new Box<Employee>(); // Employee 타입의 객체를 저장할 수 있는 Box 객체 생성
        Employee employee = new Employee(100, "Kim", "Manager", 3000);
        box4.setItem(employee);// Employee 객체를 Box 객체에 저장
        System.out.println("Box contains: " + box4.getItem());



    }
}
