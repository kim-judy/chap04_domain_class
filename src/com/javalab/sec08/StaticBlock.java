package com.javalab.sec08;


/**
 * 정적(static) 블럭 초기화
 */
public class StaticBlock {
    // 인스턴스 필드(속성)
    int field1;

    // 인스턴스 메소드
    public void method1() {
        System.out.println("method1() 호출");
    }

    // 정적 필드와 메소드 선언
    static int field2;

    public static void method2() {
        System.out.println("method2() 호출");
    }

    // 정적 블록, 클래스 로딩시 단 한번 실행, 실행되면서 정적 필드 초기화
    static {
        System.out.println("정적 블록 실행");
        //field1 = 10;    // 정적 블록에서 인스턴스 변수 접근 불가
        //method1();      // 정적 블록에서 인스턴스 메소드 호출 불가
        field2 = 10;
        method2();
    }

    // 정적 메소드 선언
    public static void method3() {
        System.out.println("method3() 호출");
        //this.field1 = 10;   // 정적 메소드에서 this 사용 불가
        //this.method1();     // 정적 메소드에서 this 사용 불가
        field2 = 10;
        method2();
    }

    public static void main(String[] args) {
        // 정적 메소드 호출
        StaticBlock.method3(); // 클래스 이름.메소드 이름으로 호출

        // 인스턴스 생성후 메소드 호출
        StaticBlock sb = new StaticBlock();
        sb.field1 = 10;
        sb.method1();

    }
}