package ru.solarsystem.model.planets;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import ru.solarsystem.model.satellite.Satellite;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;

@Component
public class Earth implements Planet {

    @Value("#{${satelliteEarthList}}")
    private List<Satellite> satellite = new ArrayList<>();


    private String name = "Земля";
    private long distance_to_sun = 149_000_000;
    private long revolution_around_sun = 365;
    private long diameter = 12_742;

    public long getDistance_to_sun() {
        return distance_to_sun;
    }

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
