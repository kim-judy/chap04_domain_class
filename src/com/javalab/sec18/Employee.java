package com.javalab.sec18;

/**
 * 사원 정보를 저장하는 클래스
 * - 사원 정보는 사원 아이디, 이름, 직급, 급여로 구성
 */
public class Employee {
    private int employeeId; // 사번
    private String name;    // 사원명, 이름
    private String position;// 직급
    private int salary;     // 급여

    public Employee() {
    }

    public Employee(int employeeId, String name, String position, int salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}