package ru.solarsystem.model.satellite;

import org.springframework.stereotype.Component;

@Component("io")
public class Io implements Satellite {

    private String name = "Ио";

    public String getName() {
        return name;
    }
}
