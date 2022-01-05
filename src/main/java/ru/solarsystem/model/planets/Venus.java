package ru.solarsystem.model.planets;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import ru.solarsystem.model.satellite.Satellite;

import java.util.List;

@Component
public class Venus implements Planet {

    private String name = "Венера";
    private long distance_to_sun = 108_000_000;

    public String getName() {
        return name;
    }
    public long getDistance() {
        return distance_to_sun;
    }

}
