package com.javalab.sec14;

class Member {

    private String id;
    private String password;
    private String name;
    private int age;

    public Member() {
    }

    public Member(String id, String password, String name, int age) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}


public class MemberMain {
    public static void main(String[] args) {


        Member member1 = new Member("Hong", "1234", "Hong", 1234);
        System.out.println(member1);

        Member member2 = new Member("Kim", "1234", "Kim", 1234);
        System.out.println(member2);

        Member member3 = new Member();
        member3.setId("Lee");
        member3.setPassword("1234");
        member3.setName("Lee");
        member3.setAge(1234);
        System.out.println(member3);

        Member member4 = new Member();
        member4.setId("Song");
        member4.setPassword("1234");
        member4.setName("Song");
        member4.setAge(1234);
        System.out.println(member4);

        Member member5 = new Member();
        member5.setId("An");
        member5.setPassword("1234");
        member5.setName("An");
        member5.setAge(1234);
        System.out.println(member5);

        Member[] arr = {member1, member2, member3, member4, member5};
        for (int i = 0; i < arr.length; i++) {
            Member item = arr[i];
            System.out.println("Id:" + item.getId() + ", Password:" + item.getPassword() + ", Name:" + item.getName() + ", Age" + item.getAge());
        }
    }
}

