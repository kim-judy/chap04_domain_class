package com.javalab.sec05;

public class CalculatorOver {
    public int add(int x, int y) {
        return x + y;
    }

    public int add(int x, int y, int z) {
        return x + y + z;
    }

    public double add(double x, double y) {
        return x + y;
    }

    public static void main(String[] args) {
        CalculatorOver myCalc = new CalculatorOver();

        int intSum = myCalc.add(5, 6);
        System.out.println(intSum);

        int intSum2 = myCalc.add(5, 6, 7);
        System.out.println(intSum2);

        double doubleSum = myCalc.add(5.3, 7.3);
        System.out.println(doubleSum);


    }
}
