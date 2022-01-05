package ru.solarsystem.model.satellite;

import org.springframework.stereotype.Component;

@Component("umbriel")
public class Umbriel implements Satellite {

    private String name = "Умбриэль";

    public String getName() {
        return name;
    }
}
