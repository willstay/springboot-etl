package com.willstay.springbootetl.deserialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.willstay.springbootetl.domain.AbstractCar;
import com.willstay.springbootetl.domain.Suv;
import com.willstay.springbootetl.domain.Truck;
import com.willstay.springbootetl.folderpaths.FolderPaths;

import java.io.File;
import java.io.IOException;

public class CarDeserialization {
    private AbstractCar car;

    public CarDeserialization(AbstractCar car) {
        this.car = car;
    }

    public void makeJson() {
        String path = "";
        ObjectMapper objectMapper = new ObjectMapper();
        if (car instanceof Truck) {
            path = FolderPaths.TRUCKS_PATH + "\\" + car.getVin() + ".json";

        }
        if (car instanceof Suv) {
            path = FolderPaths.SUV_PATH + "\\" + car.getVin() + ".json";
        }
        try {
            objectMapper.writeValue(new File(path), car);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
