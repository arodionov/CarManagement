package com.epam.model.car;

public class CarColor {

    public enum Colors {
        RED, BLACK, GREEN, NONE
    }

    public final Colors color;

    public CarColor(Colors color) {
        this.color = color;
    }

}
