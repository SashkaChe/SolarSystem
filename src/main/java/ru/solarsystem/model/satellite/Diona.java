package ru.solarsystem.model.satellite;

import org.springframework.stereotype.Component;

@Component("diona")
public class Diona implements Satellite {

    private String name = "Диона";

    public String getName() {
        return name;
    }
}
