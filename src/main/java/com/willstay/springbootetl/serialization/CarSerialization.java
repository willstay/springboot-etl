package com.willstay.springbootetl.serialization;

import com.willstay.domain.Car;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.nio.file.Path;

public class CarSerialization {
    private final Path path;

    public CarSerialization(Path path) {
        this.path = path;
    }

    public Car serialize() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Car.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        return (Car) unmarshaller.unmarshal(path.toFile());
    }
}
