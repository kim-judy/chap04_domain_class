package com.javalab.sec16;

/**
 * 직원 클래스 모델링
 * - 직원의 정보를 저장하는 클래스
 * - 필드는 사원번호, 사원명, 직급, 급여
 * - 생성자, Getter, Setter, toString 메소드 구현
 * - showEmployee 메소드 구현하여 객체 정보 출력
 */
public class Employee {
    // 필드 선언
    private int empNo;  // 사원번호
    private String eName;  // 사원명
    private String position;  // 직급
    private double salary;  // 급여
    // 생성자
    public Employee() {
    }
    public Employee(int empNo, String eName, String position, double salary) {
        this.empNo = empNo;
        this.eName = eName;
        this.position = position;
        this.salary = salary;
    }
    // Getter, Setter


    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    // 정보출력
    public void showEmployee() {
        System.out.println("사원번호: " + empNo);
        System.out.println("사원명: " + eName);
        System.out.println("직급: " + position);
        System.out.println("급여: " + salary);
    }
}
