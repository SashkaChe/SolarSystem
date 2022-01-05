package ru.solarsystem.model.planets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.solarsystem.model.satellite.Satellite;

import java.util.ArrayList;
import java.util.List;

@Component
public class Neptune implements Planet {

    @Value("#{${satelliteNeptuneList}}")
    private List<Satellite> satellite = new ArrayList<>();

    private String name = "Нептун";
    private long distance_to_sun = 4_500_000_000L;
    private long revolution_around_sun = 60190;
    private long diameter = 49244;

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