package ru.solarsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.solarsystem.data.PlanetRepository;
import ru.solarsystem.model.Planet;
import ru.solarsystem.model.Satellite;

import java.util.ArrayList;
import java.util.List;

@Service
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

    public List<Planet> findAllPlanets() {
        final Iterable<Planet> iterable = repository.findAll();

        List<Planet> result = new ArrayList<>();
        iterable.forEach(result::add);
        return result;
    }


    public Planet findPlanetByName(String name) {
        return repository.findByName(name);
    }

    public Planet findByIndex(int index) {return repository.findByIndex(index);
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
