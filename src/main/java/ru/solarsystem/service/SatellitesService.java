package ru.solarsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.solarsystem.data.SatelliteRepository;
import ru.solarsystem.model.Planet;
import ru.solarsystem.model.Satellite;

import java.util.List;

@Component
public class SatellitesService {

    private final SatelliteRepository repository;

    @Autowired
    public SatellitesService(SatelliteRepository repository) {
        this.repository = repository;
    }

    public List<Satellite> findSatellitesByPlanet(Planet planet) {
        return repository.findByPlanet(planet);
    }
}