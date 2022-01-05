package ru.solarsystem.model.planets;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.solarsystem.model.satellite.Satellite;

import java.util.ArrayList;
import java.util.List;

@Component
public class Saturn implements Planet {

    @Value("#{${satelliteSaturnList}}")
    private List<Satellite> satellite = new ArrayList<>();

    private String name = "Сатурн";
    private long distance_to_sun = 1_430_000_000;
    private long revolution_around_sun = 10_759;
    private long diameter = 120_536;

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