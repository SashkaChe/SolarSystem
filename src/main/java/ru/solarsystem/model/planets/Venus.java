package ru.solarsystem.model.planets;

import org.springframework.stereotype.Component;


@Component
public class Venus implements PlanetInterface {

    private String name = "Венера";
    private long distance_to_sun = 108_000_000;
    private long revolution_around_sun = 225;
    private long diameter = 12_100;

    public long getRevolution_around_sun() {
        return revolution_around_sun;
    }

    public long getDiameter() {
        return diameter;
    }

    public String getName() {
        return name;
    }
    public long getDistance() {
        return distance_to_sun;
    }

}
