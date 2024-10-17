package com.javalab.sec15;

/**
 * 계좌 클래스
 * - 계좌 정보를 저장하는 클래스
 * - 계좌번호, 계좌주, 잔액 필드를 갖음
 * - 계좌 생성자, 필드 Getter/Setter 메소드를 갖음
 */
public class Account {
    // 필드 선언
    private String accNo;  // 계좌번호
    private String owner;  // 계좌주
    private long balance;  // 잔액
    // 생성자
    public Account() {
    }
    // 생성자
    public Account(String accNo, String owner, long balance) {
        this.accNo = accNo;
        this.owner = owner;
        this.balance = balance;
    }
    // Getter/Setter 메소드

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    // showAccount 메소드
    public void showAccount(){
        System.out.println("계좌번호: " + accNo);
        System.out.println("예금주: " + owner);
        System.out.println("잔고: " + balance);
        System.out.println();
    }
}
