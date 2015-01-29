package com.epam.model.car;

public class CarOwner {
    private String name;
    private String surneame;

    public CarOwner() {
    }

    public CarOwner(String name, String surneame) {
        this.name = name;
        this.surneame = surneame;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurneame() {
        return surneame;
    }

    public void setSurneame(String surneame) {
        this.surneame = surneame;
    }
    
    
}
