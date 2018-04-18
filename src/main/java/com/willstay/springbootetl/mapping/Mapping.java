package com.willstay.springbootetl.mapping;

import com.willstay.domain.Car;
import com.willstay.springbootetl.domain.AbstractCar;
import com.willstay.springbootetl.domain.Suv;
import com.willstay.springbootetl.domain.Truck;

public class Mapping {
    private final Car car;

    public Mapping(Car car) {
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
