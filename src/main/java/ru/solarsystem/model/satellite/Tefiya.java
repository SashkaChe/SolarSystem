package ru.solarsystem.model.satellite;

import org.springframework.stereotype.Component;

@Component("tefiya")
public class Tefiya implements Satellite {

    private String name = "Тефия";

    public String getName() {
        return name;
    }
}

