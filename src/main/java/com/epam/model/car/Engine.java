package com.epam.model.car;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Engine implements Serializable{
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "e_model")
    private String model;
    private Integer volume;
    private Integer power;
    
    @OneToOne(mappedBy = "engine")
    private Car car;

    public Engine() {
    }

    public Engine(String model, Integer volume, Integer power) {
        this.model = model;
        this.volume = volume;
        this.power = power;
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

    public Long getId() {
        return id;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public void setCar(Car car) {
        this.car = car;
    }    
    
    public Car getCar() {
        return car;
    }    

    @Override
    public String toString() {
        return "Engine{" + "id=" + id + ", model=" + model + ", volume=" + volume + ", power=" + power + '}';
    }  
    
}
