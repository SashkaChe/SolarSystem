package ru.solarsystem.model.planets;

import org.springframework.stereotype.Component;


@Component
public class Mercury implements PlanetInterface {

    private String name = "Меркурий";
    private long distance_to_sun = 58_000_000;
    private long revolution_around_sun = 88;
    private long diameter = 4879;

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
