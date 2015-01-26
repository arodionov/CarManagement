/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.model.car;

/**
 *
 * @author andrii
 */
public class CarColor {

    public enum Colors {
        RED, BLACK, GREEN, NONE
    }

    public final Colors color;

    public CarColor(Colors color) {
        this.color = color;
    }

}
