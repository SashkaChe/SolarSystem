package ru.solarsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.solarsystem.data.PlanetRepository;
import ru.solarsystem.data.PlanetsRepo;
import ru.solarsystem.model.Planet;
import ru.solarsystem.model.Satellite;

import java.util.List;
import java.util.Optional;

@Service
public class PlanetsService {

    private final PlanetsRepo repository;

    @Autowired
    public PlanetsService(PlanetsRepo repository) {
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

    public List<Planet> findAllPlanets() {
        return repository.findAll();
    }


    public Planet findPlanetByName(String name) {
        return repository.findByName(name);
    }

    public Optional<Planet> findByIndex(int index) {return repository.findById(index);
    }

    public double numberRotationPlanet(Planet planet, int days) {
        double numberRotation = (double) days/planet.getYearDuration();

        if (numberRotation > 0) {
            return numberRotation;
        }
        return 0;
    }

    public double compareSizePlanets(Planet planet1, Planet planet2) {
        return (double) planet1.getDiameter()/planet2.getDiameter();
    }

}
