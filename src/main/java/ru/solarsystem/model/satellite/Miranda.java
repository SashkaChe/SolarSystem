package ru.solarsystem.model.satellite;

import org.springframework.stereotype.Component;

@Component("miranda")
public class Miranda implements Satellite {

    private String name = "Миранда";

    public String getName() {
        return name;
    }
}

