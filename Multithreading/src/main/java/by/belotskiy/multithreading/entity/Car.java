package by.belotskiy.multithreading.entity;

import by.belotskiy.multithreading.util.IdGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.CountDownLatch;

public class Car extends Thread{

    private final static Logger LOGGER = LogManager.getLogger(Car.class);
    private int carId;
    private int weight;
    private int area;
    private CountDownLatch latch;

    public Car(){
        this.carId = IdGenerator.generateId();
    }

    public Car(int weight, int area) {
        this.carId = IdGenerator.generateId();
        this.weight = weight;
        this.area = area;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public CountDownLatch getLatch() {
        return latch;
    }

    public void setLatch(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return weight == car.getWeight() && area == car.getArea();
    }

    @Override
    public int hashCode() {
        final int multiplier = 31;
        int result = carId;
        result = 31 * result + weight;
        result = 31 * result + area;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Car[");
        sb.append("carId=").append(carId);
        sb.append(", weight=").append(weight);
        sb.append(", area=").append(area);
        return sb.toString();
    }

    @Override
    public void run() {
        try {
            LOGGER.info("Car " + carId + " is on the boat");
            latch.await();
            LOGGER.info("Car " + carId + " is on the left bank");
        } catch (InterruptedException e) {
            LOGGER.error(e);
        }
    }
}
