package ru.solarsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.solarsystem.data.PlanetsRepo;
import ru.solarsystem.model.Planet;

import java.util.List;

@Service
public class PlanetsService {

    private final PlanetsRepo repository;

    @Autowired
    public PlanetsService(PlanetsRepo repository) {
        this.repository = repository;
    }


    public List<Planet> findAllPlanets() {
        return (List<Planet>) repository.findAll();
    }



}
