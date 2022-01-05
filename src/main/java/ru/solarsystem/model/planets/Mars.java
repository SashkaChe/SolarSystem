package ru.solarsystem.model.planets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import ru.solarsystem.model.satellite.Satellite;

import java.util.ArrayList;
import java.util.List;

@Component
@PropertySource("classpath:/prop.properties")
public class Mars implements Planet {

    @Value("#{${satelliteMarsList}}")
    private List<Satellite> satellite = new ArrayList<>();

    private String name = "Марс";
    private long distance_to_sun = 228_000_000;
    private long revolution_around_sun = 687;
    private long diameter = 6792;

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
