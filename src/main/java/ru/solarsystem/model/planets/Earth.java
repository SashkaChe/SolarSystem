package ru.solarsystem.model.planets;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import ru.solarsystem.model.satellite.Satellite;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@Component
public class Earth implements Planet {

    private String name = "Земля";
    private long distance_to_sun = 149_000_000;


    @Autowired
    @Qualifier("moon")
    private Satellite satellite;

    public String getName() {
        return name;
    }
    public long getDistance() {
        return distance_to_sun;
    }

}
