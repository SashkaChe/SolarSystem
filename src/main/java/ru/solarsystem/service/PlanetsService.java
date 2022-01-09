package ru.solarsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.solarsystem.data.PlanetRepository;
import ru.solarsystem.model.Planet;
import ru.solarsystem.model.satellite.Satellite;

import java.util.List;

@Component
public class PlanetsService {

    private final PlanetRepository repository;

    @Autowired
    public PlanetsService(PlanetRepository repository) {
        this.repository = repository;
    }

    public long getMinPlanetsDistance(Planet planet1, Planet planet2) {
        return Math.abs(planet1.getDistanceToSun() - planet2.getDistanceToSun());
    }

    public long getMaximumPlanetDistance(Planet planet1, Planet planet2) {
         return Math.abs(planet1.getDistanceToSun() + planet2.getDistanceToSun());
    }

    public List<Satellite> getSatellites(Planet planet) {
        return planet.getSatellites();
    }

    public Planet findPlanetByName(String name) {
        return repository.findByName(name);
    }
}
