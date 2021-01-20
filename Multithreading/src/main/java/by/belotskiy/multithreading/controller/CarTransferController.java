package by.belotskiy.multithreading.controller;

import by.belotskiy.multithreading.entity.Car;
import by.belotskiy.multithreading.entity.Ferry;
import by.belotskiy.multithreading.entity.FerryState;
import by.belotskiy.multithreading.exception.CarTransferException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CarTransferController {

    private final static Logger LOGGER = LogManager.getLogger(CarTransferController.class);

    public boolean transfer(List<Car> cars, Ferry ferry) throws  CarTransferException{
        try {
            while (!cars.isEmpty()) {
                loadCars(cars, ferry);
                TimeUnit.MILLISECONDS.sleep(500);
                if(unloadCars(ferry) == FerryState.CRASHED){
                    throw new CarTransferException();
                }
                TimeUnit.MILLISECONDS.sleep(500);
                LOGGER.info("FerryBoat is on the right bank");
            }
            LOGGER.info("All cars are transported");
        } catch (InterruptedException e) {
            LOGGER.error("FerryBoat work was interrupted " + e);
        }
        return cars.isEmpty();
    }

    private FerryState loadCars(List<Car> cars, Ferry ferry) throws CarTransferException {
        int tempArea = 0;
        int tempMaxWeight = 0;
        Car tempCar = null;
        ferry.setArriveLatch(new CountDownLatch(1));

        if(cars == null){
            throw new CarTransferException();
        }
        try {
            for (int i = 0; i < cars.size(); i++) {
                tempCar = cars.get(i);
                tempArea += tempCar.getArea();
                tempMaxWeight += tempCar.getWeight();
                if (tempArea <= ferry.getFerryArea() && tempMaxWeight <= ferry.getFerryMaxWeight()) {
                    tempCar.setLatch(ferry.getArriveLatch());
                    new Thread(tempCar).start();
                    TimeUnit.MILLISECONDS.sleep(100);
                    cars.remove(tempCar);
                    i--;
                } else break;
            }
            LOGGER.info("FerryBoat arrives from the right bank...");
        }catch (InterruptedException e){
            LOGGER.error("Trouble while loading boat "+e);
            throw new CarTransferException();
        }
        return FerryState.LOADED;
    }

    private FerryState unloadCars(Ferry ferry){
        try {
            LOGGER.info("Ferry on the left bank");
            ferry.getArriveLatch().countDown();
            TimeUnit.MILLISECONDS.sleep(2000);
        } catch (InterruptedException e) {
            LOGGER.error("Thread was interrupted, so ferry is broken..." + e);
            return FerryState.CRASHED;
        }
        return FerryState.EMPTY;
    }
}
