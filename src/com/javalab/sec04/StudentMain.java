package com.javalab.sec04;

public class StudentMain {
    public static void main(String[] args) {
        Student student1 = new Student();
        Student student2 = new Student("judy", 20);
        Student student3 = new Student("jeeny", 25, "class");

        student1.studentInfo();
        student2.studentInfo();
        student3.studentInfo();
    }


}
