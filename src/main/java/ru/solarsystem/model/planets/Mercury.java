package ru.solarsystem.model.planets;

import org.springframework.stereotype.Component;
import ru.solarsystem.model.satellite.Satellite;

import java.util.List;


@Component
public class Mercury implements Planet {

    private String name = "Меркурий";
    private long distance_to_sun = 58_000_000;


    public String getName() {
        return name;
    }
    public long getDistance() {
        return distance_to_sun;
    }

}
