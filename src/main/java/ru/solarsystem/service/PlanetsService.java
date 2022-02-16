package ru.solarsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.solarsystem.data.PlanetsRepoProvider;
import ru.solarsystem.model.Planet;
import ru.solarsystem.model.Satellite;

import java.util.List;

@Component
public class PlanetsService {

    private final PlanetsRepoProvider repository;

    @Autowired
    public PlanetsService(PlanetsRepoProvider repository) {
        this.repository = repository;
    }


    public List<Planet> findAllPlanets() {
        return repository.findAll();
    }



}
