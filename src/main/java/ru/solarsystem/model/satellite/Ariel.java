package ru.solarsystem.model.satellite;

import org.springframework.stereotype.Component;

@Component("ariel")
public class Ariel implements Satellite {

    private String name = "Ариэль";

    public String getName() {
        return name;
    }
}