package com.willstay.springbootetl.scheduledtasks;

import com.willstay.domain.Car;
import com.willstay.springbootetl.serialization.CarSerialization;
import com.willstay.springbootetl.domain.AbstractCar;
import com.willstay.springbootetl.domain.Suv;
import com.willstay.springbootetl.domain.Truck;
import com.willstay.springbootetl.folderpaths.FolderPaths;
import com.willstay.springbootetl.mapping.CarMapping;
import com.willstay.springbootetl.mapping.NoSuchCarException;
import com.willstay.springbootetl.messagesender.RabbitSender;
import com.willstay.springbootetl.deserialization.CarDeserialization;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private RabbitSender rabbitSender;

    @Scheduled(fixedRate = 20000)
    public void makeJson() throws IOException {
        Stream<Path> carStream = Files.walk(Paths.get(FolderPaths.CARS_PATH));
        carStream.filter(Files::isRegularFile).forEach(path -> {
            CarDeserialization carDeserialization = new CarDeserialization(path);
            try {
                Car car = carDeserialization.deSerialize();
                CarMapping carMapping = new CarMapping(car);
                try {
                    AbstractCar abstractCar = carMapping.doMap();
                    CarSerialization carSerialization = new CarSerialization(abstractCar);
                    carSerialization.makeJson();
                    path.toFile().delete();

                    if (abstractCar instanceof Truck) {
                        rabbitSender.truckDone();
                    } else if (abstractCar instanceof Suv) {
                        rabbitSender.suvsDone();
                    }
                } catch (NoSuchCarException e) {
                    System.out.println("This is not a truck or a suv");
                }
            } catch (JAXBException e) {
                System.out.println("Wrong file");
            }
        });
    }
}
