package ru.solarsystem.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.solarsystem.model.Planet;

import static org.junit.Assert.*;

public class PlanetServiceTest {

    @Autowired
    private PlanetsService service;

    @Test
    public void minimumPlanetDistance() {
        Planet one = Planet.builder().distanceToSun(10).build();
        Planet two = Planet.builder().distanceToSun(5).build();
        assertEquals(5, service.getMinPlanetsDistance(one, two));
    }

    @Test
    public void maximumPlanetDistance() {
        Planet one = Planet.builder().distanceToSun(10).build();
        Planet two = Planet.builder().distanceToSun(5).build();
        final long actual = service.getMaximumPlanetDistance(one, two);
        assertEquals(15, actual);
    }

    @Test
    public void findPlanet() {
        final String name = "Земля";
        final Planet actual = service.findPlanetByName(name);
        assertEquals(name, actual.getName());
        assertNotNull(actual.getSatellites());
        assertTrue(actual.getDistanceToSun() > 0);
    }
}
