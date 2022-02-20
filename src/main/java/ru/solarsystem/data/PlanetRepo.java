package ru.solarsystem.data;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.solarsystem.model.Planet;

public interface PlanetRepo extends JpaRepository<Planet, Integer> {
    Planet findByName(String name);
}
