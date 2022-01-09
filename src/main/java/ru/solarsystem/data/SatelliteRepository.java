package ru.solarsystem.data;

import ru.solarsystem.model.Planet;
import ru.solarsystem.model.satellite.Satellite;

import java.util.List;

public interface SatelliteRepository {
    Satellite findByName(String name);
    List<Satellite> findAll();
    List<Satellite> findByPlanet(Planet planet);
}
