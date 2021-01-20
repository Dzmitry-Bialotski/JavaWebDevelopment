package by.belotskiy.multithreading.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ferry {

    private final static Logger LOGGER = LogManager.getLogger(Ferry.class);

    private static Ferry INSTANCE = null;

    private static Lock lock = new ReentrantLock();

    private CountDownLatch arriveLatch;

    private int ferryArea;

    private int ferryMaxWeight;

    private List<Car> cars;

    private Ferry() {
    }

    public static Ferry getInstance() {
        if (INSTANCE == null) {
            lock.lock();
            try {
                if (INSTANCE == null) {
                    INSTANCE = new Ferry();
                }
            } finally {
                lock.unlock();
            }
        }
        return INSTANCE;
    }
    public int getFerryArea() {
        return ferryArea;
    }

    public void setFerryArea(int boatArea) {
        this.ferryArea = boatArea;
    }

    public int getFerryMaxWeight() {
        return ferryMaxWeight;
    }

    public void setFerryMaxWeight(int boatMaxWeight) {
        this.ferryMaxWeight = boatMaxWeight;
    }

    public void setCats(List<Car> cars){
        this.cars = cars;
    }

    public CountDownLatch getArriveLatch() {
        return arriveLatch;
    }

    public void setArriveLatch(CountDownLatch arriveLatch) {
        this.arriveLatch = arriveLatch;
    }
}
