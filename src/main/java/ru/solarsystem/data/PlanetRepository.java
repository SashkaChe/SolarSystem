package ru.solarsystem.data;

import ru.solarsystem.model.Planet;

import java.util.List;
import java.util.Optional;

public interface PlanetRepository {
    @Deprecated // use 'Optional<Planet> findById' instead
    Planet findByIndex(int id);
    Optional<Planet> findById(Integer id);
    Planet findByName(String name);
    List<Planet> findAll();
}
