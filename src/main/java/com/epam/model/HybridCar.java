
package com.epam.model;

import com.epam.model.car.Car;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
//@DiscriminatorValue("H")
public class HybridCar extends Car {
    @Enumerated(EnumType.STRING)
    private OilType oilType;
    private Double accumulatorPower;

    public OilType getOilType() {
        return oilType;
    }

    public void setOilType(OilType oilType) {
        this.oilType = oilType;
    }

    public Double getAccumulatorPower() {
        return accumulatorPower;
    }

    public void setAccumulatorPower(Double accumulatorPower) {
        this.accumulatorPower = accumulatorPower;
    }
    
    
}
