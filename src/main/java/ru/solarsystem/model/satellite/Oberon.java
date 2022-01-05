package ru.solarsystem.model.satellite;

import org.springframework.stereotype.Component;

@Component("oberon")
public class Oberon implements Satellite {

    private String name = "Оберон";

    public String getName() {
        return name;
    }
}
