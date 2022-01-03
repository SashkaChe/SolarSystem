package ru.solarsystem.model.satellite;

import org.springframework.stereotype.Component;

@Component("europe")
public class Europe implements Satellite {

    private String name = "Европа";

    public String getName() {
        return name;
    }
}
