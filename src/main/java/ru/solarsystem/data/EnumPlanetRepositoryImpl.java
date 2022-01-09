package ru.solarsystem.data;

import ru.solarsystem.model.planets.Planet;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EnumPlanetRepositoryImpl implements PlanetRepository {

    private final List<Planet> allPlanets;

    public EnumPlanetRepositoryImpl() {
        final PlanetHolder[] holders = PlanetHolder.values();
        allPlanets = Arrays.stream(holders).map(PlanetHolder::getPlanet)
                .collect(Collectors.toList());

        /* альтернативный способ инициализировать лист
        allPlanets = new ArrayList<>(holders.length);
        for (PlanetHolder planetHolder : holders) {
            allPlanets.add(planetHolder.getPlanet());
        }*/
    }

    @Override
    public Planet findByIndex(int index) {
        return allPlanets.get(index);
    }

    @Override
    public List<Planet> allPlanets() {
        return allPlanets;
    }

    @Override
    public Planet findByName(String name) {
        for (Planet planet : allPlanets) {
            if (planet.getName().equalsIgnoreCase(name)) {
                return planet;
            }
        }
        return null;
    }
}
