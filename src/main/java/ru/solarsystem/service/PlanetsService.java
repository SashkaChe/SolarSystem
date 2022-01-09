package ru.solarsystem.service;

import org.springframework.stereotype.Component;
import ru.solarsystem.model.Planet;
import ru.solarsystem.model.satellite.Satellite;

import java.util.List;

@Component
public class PlanetsService {

    public long getMinPlanetsDistance(Planet planet1, Planet planet2) {
        return Math.abs(planet1.getDistanceToSun() - planet2.getDistanceToSun());
    }

    public long getMaximumPlanetDistance(Planet planet1, Planet planet2) {
         return Math.abs(planet1.getDistanceToSun() + planet2.getDistanceToSun());
    }

    public List<Satellite> getSatellites(Planet planet) {
        return planet.getSatellites();
    }

}
