package ru.solarsystem.model.satellite;


import org.springframework.stereotype.Component;

@Component("yapet")
public class Yapet implements Satellite {

    private String name = "Япет";

    public String getName() {
        return name;
    }
}
