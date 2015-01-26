package com.epam.model.car;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Engine implements Serializable{
    @Column(name = "e_model")
    private String model;
    private Integer volume;

    public Engine() {
    }

    public Engine(String model, Integer volume) {
        this.model = model;
        this.volume = volume;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Engine{" + "model=" + model + ", volume=" + volume + '}';
    }    
}
