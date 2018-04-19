package com.willstay.springbootetl.scheduledtasks;

import com.willstay.domain.Car;
import com.willstay.springbootetl.deserialization.CarDeserialization;
import com.willstay.springbootetl.domain.AbstractCar;
import com.willstay.springbootetl.folderpaths.FolderPaths;
import com.willstay.springbootetl.mapping.CarMapping;
import com.willstay.springbootetl.mapping.NoSuchCarException;
import com.willstay.springbootetl.serialization.CarSerialization;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Component
public class ScheduledTask {
    @Scheduled(fixedRate = 20000)
    public void makeJson() throws IOException {
        Stream<Path> carStream = Files.walk(Paths.get(FolderPaths.CARS_PATH));
        carStream.filter(Files::isRegularFile).forEach(path -> {
            CarSerialization carSerialization = new CarSerialization(path);
            try {
                Car car = carSerialization.serialize();
                CarMapping carMapping = new CarMapping(car);
                try {
                    AbstractCar abstractCar = carMapping.doMap();
                    CarDeserialization carDeserialization = new CarDeserialization(abstractCar);
                    carDeserialization.makeJson();
                    path.toFile().delete();
                } catch (NoSuchCarException e) {
                    System.out.println("This is not a truck or a suv");
                }
            } catch (JAXBException e) {
                System.out.println("Wrong file");
            }
        });
    }
}
