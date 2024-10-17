package com.javalab.sec16;

public class StudentMain {
    public static void main(String[] args) {
        //[순서]
        // 1. Student 객체 생성
        // 2. 생성된 객체를 Stdudent Type Array에 저장
        // 3. Student List 출력
        // 4. 총인원출력
        // 5. 평균점수 출력
        // 6. 최고점 학생명, 점수 출력

        // 1. 학생 데이터 생성
        Student[] students = initializeStudent(); // 학생 데이터 생성 메소드에서 학생 데이터 생성하고 그 주소를 전다해줌.

        // 2. 학생 데이터 출력
        printSudentList(students);

        // 3. 총인원 출력
        System.out.println("총인원 : " + students.length);

        // 4. 평균점수 출력 메소드 호출
        printAvgScore(students);

        // 5. 최고점 학생명, 점수 출력 메소드 호출
        printMaxScoreStudent(students);


    } // end of main

    // 최고점 학생명과 점수 출력
    private static void printMaxScoreStudent(Student[] students) {
        int max = 0;
        String maxName = "";
        for (int i = 0; i < students.length; i++) {
            if (students[i].getScore() > max) {
                max = students[i].getScore();
                maxName = students[i].getName();
            }
        }
        System.out.println("최고 점수는 : " + max + "점 이며 최고점의 학생은 : " + maxName + "님 입니다.");
    }

    private static void printAvgScore(Student[] students) {
        int sum = 0;
        double avg = 0.0;
        for (int i = 0; i < students.length; i++) {
            sum += students[i].getScore();
        }
        avg = (sum * 1.0) / students.length;
        //System.out.println("평균점수 : " + avg);
        System.out.printf("평균점수 : %.2f\n", avg);
    }

    private static void printSudentList(Student[] students) {
        System.out.println("=============================================");
        System.out.println(" name   age    gender       phone      score");
        System.out.println("---------------------------------------------");
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i].getName() + "\t" + students[i].getAge()  + "\t" +
                                students[i].getGender() + "\t" + students[i].getPhone() + "\t" +
                                students[i].getScore());
        }
        System.out.println("=============================================");
    }

    // 학생 객체를 만들어주는 역할
    private static Student[] initializeStudent() {
        Student[] sts = new Student[5];
        sts[0] = new Student("김홍철", 23, '남', "010-2340-1233", 85);
        sts[1] = new Student("정순미", 24 , '여', "010-9857-7532", 70);
        sts[2] = new Student("이만섭", 22 , '남', "010-6548-4687", 96);
        sts[3] = new Student("최주호", 20 , '남', "010-2528-9368", 85);
        sts[4] = new Student("고미림", 26 , '여', "010-1068-2549", 77);
        return sts;
    }
}
