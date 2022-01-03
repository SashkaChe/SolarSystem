package ru.solarsystem.model.planets;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.solarsystem.model.satellite.Satellite;

import java.util.ArrayList;
import java.util.List;

@Component
public class Jupiter implements Planet {

    @Value("#{${satelliteJupiterList}}")
    private List<Satellite> satellite = new ArrayList<>();

    private String name = "Юпитер";
    private long distance_to_sun = 778_000_000;


    public List<Satellite> getSat() {
        return satellite;
    }
    public String getName() {
        return name;
    }
    public long getDistance() {
        return distance_to_sun;
    }

}
