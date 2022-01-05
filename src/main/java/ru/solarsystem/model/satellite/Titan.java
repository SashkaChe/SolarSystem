package ru.solarsystem.model.satellite;

import org.springframework.stereotype.Component;

@Component("titan")
public class Titan implements Satellite {

    private String name = "Титан";

    public String getName() {
        return name;
    }
}