package com.javalab.sec12;

public class Car {

    private String model;
    private int speed;

    public Car() {
    }

    public Car(String model, int speed) {
        this.model = model;
        this.speed = speed;
    }


    //Getter/Setter
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
