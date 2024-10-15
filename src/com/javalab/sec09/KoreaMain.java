package com.javalab.sec09;


class Korea {
    final String nation = "대한민국";
    String name;

    public Korea(String name) {
        this.name = name;
    }
}

public class KoreaMain {
    public static void main(String[] args) {
        Korea korea = new Korea("judy");
        System.out.println(korea.nation);
        System.out.println(korea.name);
    }

}
