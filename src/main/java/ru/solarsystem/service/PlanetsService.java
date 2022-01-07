package ru.solarsystem.service;

import org.springframework.stereotype.Component;
import ru.solarsystem.model.planets.Planet;
import ru.solarsystem.model.satellite.Satellite;

import java.util.List;

@Component
public class PlanetsService {


    public long getMinPlanetsDistance(Planet planet1, Planet planet2) {
        return Math.abs(planet1.getDistance() - planet2.getDistance());
    }

    public long getMaximumPlanetDistance(Planet planet1, Planet planet2) {
         return Math.abs(planet1.getDistance() + planet2.getDistance());
    }

    public List<Satellite> getSatellites(Planet planet) {
        return planet.getSat();
    }

}
