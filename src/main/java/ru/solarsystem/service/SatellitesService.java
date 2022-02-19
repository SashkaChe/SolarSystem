package ru.solarsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.solarsystem.data.PlanetsRepo;
import ru.solarsystem.data.SatellitesRepo;
import ru.solarsystem.model.Planet;
import ru.solarsystem.model.Satellite;

import java.util.List;

@Component
public class SatellitesService {

    private final SatellitesRepo repository;

    @Autowired
    public SatellitesService(SatellitesRepo repository) {
        this.repository = repository;
    }


}