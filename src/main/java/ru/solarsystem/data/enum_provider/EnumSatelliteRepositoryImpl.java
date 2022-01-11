package ru.solarsystem.data.enum_provider;

import ru.solarsystem.data.SatelliteRepository;
import ru.solarsystem.model.Planet;
import ru.solarsystem.model.Satellite;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EnumSatelliteRepositoryImpl implements SatelliteRepository {

    private final List<Satellite> allSatellites;

    EnumSatelliteRepositoryImpl() {
    this.allSatellites = Arrays.stream(SatelliteHolder.values()).map(SatelliteHolder::getSatellite).collect(Collectors.toList());
    }

    public List<Satellite> findAll() {return allSatellites;}

    public Satellite findByName(String name) {
        for(Satellite obj : allSatellites) {
            if (obj.getName().equalsIgnoreCase(name)) {
                return obj;
            }
        }
        return null;
    }

    public List<Satellite> findByPlanet(Planet planet) {
        return planet.getSatellites();
    }

}
