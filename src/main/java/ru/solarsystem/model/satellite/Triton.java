package ru.solarsystem.model.satellite;

import org.springframework.stereotype.Component;

@Component("triton")
public class Triton implements Satellite {

    private String name = "Тритон";

    public String getName() {
        return name;
    }
}
