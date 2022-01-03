package ru.solarsystem.model.satellite;

import org.springframework.stereotype.Component;

@Component("ganymede")
public class Ganymede implements Satellite {

    private String name = "Ганимед";

    public String getName() {
        return name;
    }
}
