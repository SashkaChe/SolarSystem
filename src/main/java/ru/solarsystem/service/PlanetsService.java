package ru.solarsystem.service;

import org.springframework.stereotype.Component;
import ru.solarsystem.model.planets.PlanetInterface;
import ru.solarsystem.model.satellite.Satellite;

import java.util.List;

@Component
public class PlanetsService {


    public long getMinPlanetsDistance(PlanetInterface planet1, PlanetInterface planet2) {
        return Math.abs(planet1.getDistance() - planet2.getDistance());
    }

    public long getMaximumPlanetDistance(PlanetInterface planet1, PlanetInterface planet2) {
         return Math.abs(planet1.getDistance() + planet2.getDistance());
    }

    public List<Satellite> getSatellites(PlanetInterface planet) {
        return planet.getSat();
    }

}
