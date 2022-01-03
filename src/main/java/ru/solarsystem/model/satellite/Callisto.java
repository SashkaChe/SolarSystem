package ru.solarsystem.model.satellite;

import org.springframework.stereotype.Component;


@Component("callisto")
public class Callisto implements Satellite {

    private String name = "Каллисто";

    public String getName() {
        return name;
    }
}