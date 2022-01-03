package ru.solarsystem.model.satellite;

import org.springframework.stereotype.Component;

@Component("deimos")
public class Deimos implements Satellite {

    private String name = "Деймос";

    public String getName() {
        return name;
    }
}
