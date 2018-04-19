package com.willstay.springbootetl.mapping;

import com.willstay.domain.Car;
import com.willstay.springbootetl.domain.AbstractCar;
import com.willstay.springbootetl.domain.Suv;
import com.willstay.springbootetl.domain.Truck;

public class CarMapping {
    private final Car car;

    public CarMapping(Car car) {
        this.car = car;
    }

    public AbstractCar doMap() {
        if (car.getType().equals("truck")) {
            return new Truck(
                    car.getVin(),
                    car.getMilage(),
                    car.getLocation(),
                    car.getPrice(),
                    car.getMaxWeight()
            );
        }
        if (car.getType().equals("suv")) {
            return new Suv(
                    car.getVin(),
                    car.getMilage(),
                    car.getLocation(),
                    car.getPrice()
            );
        }
        throw new NoSuchCarException();
    }
}
