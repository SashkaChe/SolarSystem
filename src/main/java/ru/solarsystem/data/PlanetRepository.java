package ru.solarsystem.data;

import ru.solarsystem.model.planets.Planet;

import java.util.List;

public interface PlanetRepository {
    Planet findByIndex(int id);
    Planet findByName(String name);
    List<Planet> allPlanets();
}
