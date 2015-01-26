package com.epam.model.car;

import com.epam.model.utils.ColorConvertor;
import java.util.Arrays;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

@Entity
@Table(name = "Car",
        indexes = {@Index(columnList = "model,power", name = "model_power")},
        uniqueConstraints = {@UniqueConstraint(name = "model_power_const", columnNames = {"model", "power"})}
)
@SecondaryTable(name = "CarOwner")
//@DiscriminatorColumn(name = "Type")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Car {    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String model;
    private Integer power;
    @Embedded
    private Engine engine;
    @Enumerated(EnumType.STRING)
    private CarType carType;
    @Column(name = "OwnerName", table = "CarOwner")
    private String carOwnerName;
    @Column(name = "OwnerSurname", table = "CarOwner")
    private String carOwnerSurname;
    @Version
    private Long version;
    @Transient
    private Long carId;
    //@Column(columnDefinition = "CLOB NOT NULL")
    private byte[] photo;
    @Convert(converter = ColorConvertor.class)
    private CarColor color;

    public Car() {
    } 

    public Car(String model, Integer power, Engine engine) {
        this.model = model;
        this.power = power;
        this.engine = engine;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }    

    public String getCarOwnerName() {
        return carOwnerName;
    }

    public void setCarOwnerName(String carOwnerName) {
        this.carOwnerName = carOwnerName;
    }

    public String getCarOwnerSurname() {
        return carOwnerSurname;
    }

    public void setCarOwnerSurname(String carOwnerSurname) {
        this.carOwnerSurname = carOwnerSurname;
    }    

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }    

    public CarColor getColor() {
        return color;
    }

    public void setColor(CarColor color) {
        this.color = color;
    }  
        
    @Override
    public String toString() {
        return "Car{" + "id=" + id + ", model=" + model + ", power=" + power + ", engine=" + engine + " " + Arrays.toString(photo) + '}';
    }    
    
}
