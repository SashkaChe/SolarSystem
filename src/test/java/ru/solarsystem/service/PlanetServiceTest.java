package ru.solarsystem.service;

import org.junit.Test;
import ru.solarsystem.data.enum_provider.EnumPlanetRepositoryImpl;
import ru.solarsystem.model.Planet;

import static org.junit.Assert.*;

public class PlanetServiceTest {
/*
    // не использует Спринг, не знает про бины
    private final PlanetService service = new PlanetService(new EnumPlanetRepositoryImpl());

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
    public void rotationPlanet() {
        final double DELTA = 1e-4;
        Planet one = Planet.builder().yearDuration(4000).build();
        final double actual = service.numberRotationPlanet(one, 5000);
        assertEquals(1.25, actual, DELTA);
        final double actual2 = service.numberRotationPlanet(one, -5000);
        assertEquals(0, actual2, DELTA);
        assertEquals(0, service.numberRotationPlanet(one, 0), DELTA);
        final double fraction = service.numberRotationPlanet(one, 4);
        assertEquals(0.001, fraction, DELTA);
        Planet shortPeriod = Planet.builder().yearDuration(12).build();
        assertEquals(5, service.numberRotationPlanet(shortPeriod, 60), DELTA);
        assertEquals(1, service.numberRotationPlanet(shortPeriod, 12), DELTA);
    }

    @Test
    public void findPlanet() {
        final String name = "Земля";
        final Planet actual = service.findPlanetByName(name);
        assertEquals(name, actual.getName());
        assertNotNull(actual.getSatellites());
        assertTrue(actual.getDistanceToSun() > 0);
    }


 */
}
