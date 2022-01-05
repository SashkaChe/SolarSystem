package ru.solarsystem.model.satellite;

import org.springframework.stereotype.Component;

@Component("titaniya")
public class Titaniya implements Satellite {

    private String name = "Титания";

    public String getName() {
        return name;
    }
}