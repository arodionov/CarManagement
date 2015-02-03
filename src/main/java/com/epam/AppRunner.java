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
import com.epam.model.car.CarModel;
import com.epam.model.car.TechRecord;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.epam.model.car.Detail;

public class AppRunner {
    
    public static void main(String[] args) {
        String persistenceUnit = "HibernatePostgreSQL";
        //String persistenceUnit = "EclipseLinkPostgreSQL";
        //String persistenceUnit = "EclipseLinkMySQL";
        //String persistenceUnit = "HiberanteMySQL";
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnit);
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        
        OilCar oilCar = constructOilCar();
        ElectricCar electricCar = constructElectricCar();
        HybridCar hybridCar = constructHybridCar();
        hybridCar.getTechRecords().add(
                new TechRecord("Check oil", new Date(), "Been"));
        hybridCar.getTechRecords().add(
                new TechRecord("Check accumulator", new Date(), "Been"));
        
//        Query carsQuery = em.createQuery("select c from Car c");
//        List<Car> cars = carsQuery.getResultList();
//        cars.stream()
//                //.filter(c -> Objects.equals(c.getModel(), "Zap"))
//                //.peek(System.out::println)
//                .forEach(System.out::println);
//        
//        cars.stream()
//                .flatMap(c -> c.getTechRecords().stream())
//                .filter(tr -> "Been".equals(tr.getAuthor()))
//                .forEach(tr -> tr.setAuthor("Mr. Been"));
//        
//        Query engineQuery = em.createQuery("select e from Engine e");
//        List<Engine> engines = engineQuery.getResultList();
//        engines.stream()
//                .map(e -> e.getCar())
//                .forEach(c -> c.setCarOwnerSurname("Rodionov"));
        
        //engines.get(0).getCar().setEngine(engines.get(1));
        
//        Query modelQuery = em.createQuery("select m from CarModel m WHERE m.id = 177");
//        CarModel model = (CarModel) modelQuery.getSingleResult();
//        System.out.println(model.getCars());
        
        CarModel carModel = new CarModel("Sedan");
        hybridCar.setModel(carModel);
        oilCar.setModel(carModel);
        
        Detail detail = new Detail("Window");
        oilCar.getDetailes().add(detail);
        electricCar.getDetailes().add(detail);
        hybridCar.getDetailes().add(detail);
        
        et.begin();
        try {
            em.persist(oilCar);
            em.persist(electricCar);
            em.persist(hybridCar);
            et.commit();
        } catch (Exception e) {
            e.printStackTrace();
            et.rollback();            
        } finally {
            em.close();
            emf.close();
        }
    }
    
    private static OilCar constructOilCar() {
        OilCar oilCar = new OilCar();
        oilCar.setModel(new CarModel("BMW"));       
        oilCar.setEngine(new Engine("BMW", 30, 400));
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
        electricCar.setModel(new CarModel("Tesla"));     
        electricCar.setEngine(new Engine("Tesla", 0, 200));
        electricCar.setCarType(CarType.CLASSIC);
        electricCar.setCarOwnerName("Andii");
        electricCar.setCarOwnerSurname("Rod");
        electricCar.setPhoto(new byte[]{1, 2, 3, 4, 5});
        electricCar.setColor(new CarColor(CarColor.Colors.BLACK));
        electricCar.setAccumulatorPower(380.0);
        return electricCar;
    }
    
    private static HybridCar constructHybridCar() {
        HybridCar hybridCar = new HybridCar();
        //hybridCar.setModel(null);      
        hybridCar.setEngine(new Engine("GM", 10, 300));
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
