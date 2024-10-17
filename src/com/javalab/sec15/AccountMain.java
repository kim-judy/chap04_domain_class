package com.javalab.sec15;

public class AccountMain {
    public static void main(String[] args) {
        // 1. Account 객체 2개를 오버로딩 생성자 통해서 생성
        Account acc1 = new Account("123-456-789", "홍길동", 100000 );
        Account acc2 = new Account("987-654-321", "이순신", 200000 );
        // 2. Account 객체 1개를 기본 생성자로 생성 후 setter 메소드로 필드값 설정
        Account acc3 = new Account(); // 빈 객체 생성
        acc3.setAccNo("555-666-777");
        acc3.setOwner("김유신");
        acc3.setBalance(300000);
        // 3. acc1 객체의 값 출력
        System.out.println("=== 계좌 정보 출력 ===");
        System.out.println("계좌번호: " + acc1.getAccNo()); // "123-456-789"
        System.out.println("예금주: " + acc1.getOwner()); // "홍길동"
        System.out.println("잔고: " + acc1.getBalance()); // 100000
        // 4. acc2 객체의 값 출력(입금/출금) - 이순신 계좌 입금 2000원, 출금 5000원
        acc2.setBalance(acc2.getBalance() + 2000); // 202000(입금)
        acc2.setBalance(acc2.getBalance() - 5000); // 197000(출금)
        System.out.println(acc2.getOwner() + "님의 잔고: " + acc2.getBalance() + "원");
        // 5. showAccount 메소드로 객체 출력
        System.out.println("=== 계좌 정보 출력 ===");
        acc1.showAccount();
        acc2.showAccount();
        acc3.showAccount();

        // 6. 계좌 평균 잔고 출력
        long totalBalance = acc1.getBalance() + acc2.getBalance() + acc3.getBalance();
        long avgBalance = totalBalance / 3;
        System.out.println("평균잔고: " + avgBalance);

        // 7. 배열로 계좌 관리
        //Account[] accountArr = {acc1, acc2, acc3};
        Account[] accountArr = new Account[3]; // Account 객체 3개를 저장할 수 있는 배열 생성
        accountArr[0] = acc1;   // 배열의 첫번째 인덱스 위치에 acc1 객체 저장
        accountArr[1] = acc2;
        accountArr[2] = acc3;

        // 8. 계좌 목록 출력
        System.out.println("배열을 통한 계좌 목록 출력");
        accountArr[0].showAccount();
        accountArr[1].showAccount();
        accountArr[2].showAccount();
        System.out.println("===================================");

        // 9. 배열을 이용하여 평균 잔고 출력
        totalBalance = 0;
        for (Account account : accountArr) {
            totalBalance += account.getBalance();
        }
        avgBalance = totalBalance / accountArr.length;
        System.out.println("평균잔고: " + avgBalance);

        // 10. 모든 계좌의 잔고에 50000원 입금, 다시 계좌 목록 출력
        System.out.println("=== 모든 계좌에 50,000원 입금 ===");
        for (Account account : accountArr) {
            long tempBalance = account.getBalance();
            account.setBalance(tempBalance + 50000);
        }

        // 11. 모든 계좌 출력
        System.out.println("=== 반복문을 통한 계좌 목록 출력 ===");
        for (Account account : accountArr) {
            account.showAccount();
        }

    }
}
