package ru.solarsystem.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ru.solarsystem.model.Planet;

public interface PlanetsRepo extends JpaRepository<Planet, Integer> {
}
