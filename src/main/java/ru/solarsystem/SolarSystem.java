package ru.solarsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.RestController;
import ru.solarsystem.controller.ConsoleController;
import ru.solarsystem.model.Planet;
import ru.solarsystem.mvc_config.SpringConfig;



@RestController
public class SolarSystem {

    public static void main(String[] args) {
        SpringApplication.run(SpringConfig.class, args);
    }

}
