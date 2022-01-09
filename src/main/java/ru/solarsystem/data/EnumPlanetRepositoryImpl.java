package ru.solarsystem.data;

import ru.solarsystem.model.planets.Planet;

public class EnumPlanetRepositoryImpl implements PlanetRepository {


    @Override
    public Planet findByIndex(int id) {
        final PlanetHolder[] allPlanets = allPlanets();
        return allPlanets[id].getPlanet();
    }

    private PlanetHolder[] allPlanets() {
        final PlanetHolder[] allPlanets = PlanetHolder.values();
        return allPlanets;
    }

    @Override
    public Planet findByName(String name) {
        final PlanetHolder[] allPlanets = allPlanets();
        for (PlanetHolder planetHolder : allPlanets) {
            if (planetHolder.getPlanet().getName().equalsIgnoreCase(name)) {
                return planetHolder.getPlanet();
            }
        }
        return null;
    }
}
