package ru.solarsystem.model.satellite;

import org.springframework.stereotype.Component;

@Component("rhea")
public class Rhea implements Satellite {

    private String name = "Рея";

    public String getName() {
        return name;
    }
}
