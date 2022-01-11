package ru.solarsystem.data.enum_provider;

import org.springframework.stereotype.Component;
import ru.solarsystem.data.SatelliteRepository;
import ru.solarsystem.model.Planet;
import ru.solarsystem.model.Satellite;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EnumSatelliteRepositoryImpl implements SatelliteRepository {

    private final List<Satellite> allSatellites;

    EnumSatelliteRepositoryImpl() {
    this.allSatellites = Arrays.stream(SatelliteHolder.values()).map(SatelliteHolder::getSatellite).collect(Collectors.toList());
    }

    @Override
    public List<Satellite> findAll() {return allSatellites;}

    @Override
    public Satellite findByName(String name) {
        for(Satellite obj : allSatellites) {
            if (obj.getName().equalsIgnoreCase(name)) {
                return obj;
            }
        }
        return null;
    }

    @Override
    public List<Satellite> findByPlanet(Planet planet) {
        return planet.getSatellites();
    }

}
