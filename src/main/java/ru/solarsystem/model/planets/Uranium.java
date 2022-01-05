package ru.solarsystem.model.planets;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.solarsystem.model.satellite.Satellite;

import java.util.ArrayList;
import java.util.List;

@Component
public class Uranium implements Planet {

    @Value("#{${satelliteUraniumList}}")
    private List<Satellite> satellite = new ArrayList<>();

    private String name = "Уран";
    private long distance_to_sun = 2800000000L;
    private long revolution_around_sun = 30685;
    private long diameter = 50724;

    public long getRevolution_around_sun() {
        return revolution_around_sun;
    }

    public long getDiameter() {
        return diameter;
    }

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

