/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.model;

import com.epam.model.car.Car;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author andrii
 */
@Entity
//@DiscriminatorValue("E")
public class ElectricCar extends Car {
    private Double accumulatorPower;

    public Double getAccumulatorPower() {
        return accumulatorPower;
    }

    public void setAccumulatorPower(Double accumulatorPower) {
        this.accumulatorPower = accumulatorPower;
    }   
    
}
