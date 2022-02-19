package ru.solarsystem.data.enum_provider;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.solarsystem.data.PlanetRepository;
import ru.solarsystem.model.Planet;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@Slf4j
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
        log.info("entering EnumPlanetRepositoryImpl.findByIndex("+index);
        return allPlanets.get(index);
    }

    @Override
    public Optional<Planet> findById(Integer id) {
        return Optional.of(findByIndex(id));
    }

    @Override
    public List<Planet> findAll() {
        log.info("entering EnumPlanetRepositoryImpl.findAll");
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
