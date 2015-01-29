package com.epam.model.car;

import com.epam.model.utils.ColorConvertor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

@Entity
@Table(name = "Car",
        indexes = {@Index(columnList = "model,Engine_ID", name = "model_engine")},
        uniqueConstraints = {@UniqueConstraint(name = "model_engine_const", columnNames = {"model", "Engine_ID"})}
)
@SecondaryTable(name = "CarOwner", pkJoinColumns = @PrimaryKeyJoinColumn(name = "Car_ID"))
//@DiscriminatorColumn(name = "Type")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Car {    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String model;    
    
    @OneToOne(cascade = CascadeType.PERSIST, orphanRemoval = true)
    @JoinColumn(name = "Engine_ID")
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
    
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "Car_TechRecord",
            joinColumns = @JoinColumn(name = "Car_ID"))    
    private List<TechRecord> techRecords = new ArrayList<>();

    public Car() {
    } 

    public Car(String model, Integer power, Engine engine) {
        this.model = model;      
        this.engine = engine;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
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

    public List<TechRecord> getTechRecords() {
        return techRecords;
    }

    public void setTechRecords(List<TechRecord> techRecords) {
        this.techRecords = techRecords;
    }    
    
    @Override
    public String toString() {
        return "Car{" + "id=" + id + ", model=" + model + ", engine=" + engine + " " + Arrays.toString(photo) + '}';
    }    
    
}
