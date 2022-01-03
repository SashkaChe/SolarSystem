package ru.solarsystem.model.satellite;


import org.springframework.stereotype.Component;

@Component("fobos")
public class Fobos implements Satellite {

    private String name = "Фобос";

    public String getName() {
        return name;
    }
}
