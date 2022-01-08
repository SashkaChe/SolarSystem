package ru.solarsystem.model.planets;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.solarsystem.model.satellite.Satellite;

import java.util.ArrayList;
import java.util.List;

@Component
public class Jupiter implements PlanetInterface {

    @Value("#{${satelliteJupiterList}}")
    private List<Satellite> satellite = new ArrayList<>();

    private String name = "Юпитер";
    private long distance_to_sun = 778_000_000;
    private long revolution_around_sun = 4332;
    private long diameter = 143_884;

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
