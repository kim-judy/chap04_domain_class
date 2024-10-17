package com.javalab.sec16;

public class EmployeeMain {
    public static void main(String[] args) {

        // 1. 생성자를 통한 두 개의 객체 생성
        Employee emp1 = new Employee(2023010001, "김수희", "대리", 310.0);
        Employee emp2 = new Employee(2023010002, "박미선", "사원", 280.0);
        // 2. 빈객 생성후 세터 메소드를 통한 값 설정
        Employee emp3 = new Employee();
        emp3.setEmpNo(2023010003);
        emp3.seteName("최종현");
        emp3.setPosition("과장");
        emp3.setSalary(400.0);
        // 3. 사원객체 배열(3칸) 생성
        Employee[] emps = new Employee[3]; // Employee Type 객체가 저장될 수 있는 3칸 배열생성
        emps[0] = emp1; // 배열의 첫번째 칸에 emp1 객체 저장
        emps[1] = emp2; // 배열의 두번째 칸에 emp2 객체 저장
        emps[2] = emp3; // 배열의 세번째 칸에 emp3 객체 저장
        // 4. for-each 문을 통한 일괄 조회
        for (Employee emp : emps) {
            System.out.println(emp.getEmpNo() + " " + emp.geteName() + " " + emp.getPosition() + " " + emp.getSalary());
        }
        System.out.println("=================이름-급여====================");
        // 5. 사원들의 이름과 급여만 출력
        for (Employee emp : emps) {
            System.out.println(emp.geteName() + " " + emp.getSalary());
        }
        // 6. 모든 사원들의 급여를 10% 인상(기존급여 * 1.1)
        System.out.println("===========급여 10% 인상 후============");
        for (Employee emp : emps) {
            emp.setSalary(emp.getSalary() * 1.1); // 기존급여 + (기존급여 * 0.1)
        }
        // 7. 모든 사원들의 이름과 급여를 출력
        for (Employee emp : emps) {
            //System.out.println(emp.geteName() + " " + emp.getSalary());
            // 소숫점 2자리까지 출력
             System.out.printf("%s %.2f\n", emp.geteName(), emp.getSalary());
        }
        // 8. 모든 사원의 급여 10% 인상 로직을 별도의 메소드로 분리(모듈화)
        raiseSalary(emps);
        System.out.println("===========급여 10% 인상 후(모듈화)============");
        // 9. 모든 사원들의 이름과 급여 출력메소드를 분리(모듈화)
        showEmployeeInfo(emps);
        // 10. 사원 한명 출력하는 메소드를 분리(모듈화)\
        System.out.println("===========사원 한명 출력(모듈화)============");
        showEmployee(emps[0]);

        // 14. 전사원들의 급여 합계를 계산해주는 메소드(모듈화)
        double longSal = sumSallary(emps);
        System.out.println("전사원 급여 합계 : " + longSal);

    } // end of main

    // 전 사원들의 급여 합계 계산 메소드
    private static double sumSallary(Employee[] emps) {
        // for-each문 반복
        double sum = 0.0;
        for (Employee emp : emps) {
            sum += emp.getSalary();
        }
        return sum;
    }

    // 11. 사원들의 이름과 급여를 출력하는 메소드
    private static void showEmployeeInfo(Employee[] emps) {
        for (Employee emp : emps) {
            // 소숫점 2자리까지 출력
            System.out.printf("%s %.2f\n", emp.geteName(), emp.getSalary());
        }
    }
    // 12. 급여를 10% 인상하는 메소드
    private static void raiseSalary(Employee[] emps) {
        for (Employee emp : emps) {
            emp.setSalary(emp.getSalary() * 1.1); // 기존급여 + (기존급여 * 0.1)
        }
    }
    // 13. 사원 한명의 정보를 출력하는 메소드
    private static void showEmployee(Employee emp) {
        System.out.println(emp.getEmpNo() + " " + emp.geteName() + " " + emp.getPosition()
                            + " " + emp.getSalary());
    }


}
