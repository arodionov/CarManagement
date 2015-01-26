package com.epam;

import com.epam.model.car.Car;
import com.epam.model.car.CarOwner;
import com.epam.model.car.CarType;
import com.epam.model.car.CarColor;
import com.epam.model.ElectricCar;
import com.epam.model.car.Engine;
import com.epam.model.HybridCar;
import com.epam.model.OilCar;
import com.epam.model.OilType;
import java.util.List;
import java.util.Objects;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class AppRunner {

    public static void main(String[] args) {
        //String persistenceUnit = "HibernatePostgreSQL";
        //String persistenceUnit = "EclipseLinkPostgreSQL";
        //String persistenceUnit = "EclipseLinkMySQL";
        String persistenceUnit = "HiberanteMySQL";
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnit);
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        OilCar oilCar = constructOilCar();
        ElectricCar electricCar = constructElectricCar();
        HybridCar hybridCar = constructHybridCar();        

        Query q = em.createQuery("select c from Car c");
        List<Car> cars = q.getResultList();
        cars.stream()        
                //.filter(c -> Objects.equals(c.getModel(), "Zap"))
                .peek(System.out::println)
                .forEach(c -> c.setCarOwnerSurname("Rodionov"));
        //Car car = cars.get(0);

        et.begin();
        try {
            em.persist(oilCar);
            em.persist(electricCar);
            em.persist(hybridCar);
            et.commit();
        } catch (Exception e) {
            et.rollback();
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }

    private static OilCar constructOilCar() {
        OilCar oilCar = new OilCar();
        oilCar.setModel("BMW");
        oilCar.setPower(400);
        oilCar.setEngine(new Engine("BMW", 30));
        oilCar.setCarType(CarType.JEEP);
        oilCar.setCarOwnerName("Andii");
        oilCar.setCarOwnerSurname("Rod");
        oilCar.setPhoto(new byte[]{1, 2, 3});
        oilCar.setColor(new CarColor(CarColor.Colors.GREEN));
        oilCar.setOilType(OilType.GASOLINE);
        return oilCar;
    }
    
    private static ElectricCar constructElectricCar() {
        ElectricCar electricCar = new ElectricCar();
        electricCar.setModel("Tesla");
        electricCar.setPower(400);
        electricCar.setEngine(new Engine("Tesla", 0));
        electricCar.setCarType(CarType.CLASSIC);
        electricCar.setCarOwnerName("Andii");
        electricCar.setCarOwnerSurname("Rod");
        electricCar.setPhoto(new byte[]{1, 2, 3, 4, 5});
        electricCar.setColor(new CarColor(CarColor.Colors.GREEN));
        electricCar.setAccumulatorPower(380.0);
        return electricCar;
    }
    
    private static HybridCar constructHybridCar() {
        HybridCar hybridCar = new HybridCar();
        hybridCar.setModel("Sedan");
        hybridCar.setPower(400);
        hybridCar.setEngine(new Engine("GM", 10));
        hybridCar.setCarType(CarType.JEEP);
        hybridCar.setCarOwnerName("Andii");
        hybridCar.setCarOwnerSurname("Rod");
        hybridCar.setPhoto(new byte[]{1, 2, 3, 4});
        hybridCar.setColor(new CarColor(CarColor.Colors.RED));
        hybridCar.setAccumulatorPower(380.0);
        hybridCar.setOilType(OilType.GAS);        
        return hybridCar;
    }

}
