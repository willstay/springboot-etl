package com.willstay.springbootetl.deserialization;

import com.willstay.domain.Car;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.nio.file.Path;

public class CarDeserialization {
    private final Path path;

    public CarDeserialization(Path path) {
        this.path = path;
    }

    public Car deSerialize() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Car.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        return (Car) unmarshaller.unmarshal(path.toFile());
    }
}
