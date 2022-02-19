package ru.solarsystem.data;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.solarsystem.model.Satellite;

public interface SatellitesRepo extends JpaRepository<Satellite, Integer> {
}
