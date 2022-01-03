package ru.solarsystem.model.satellite;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component("moon")
public class Moon implements Satellite {

    private String name = "Луна";

    public String getName() {
        return name;
    }


}
