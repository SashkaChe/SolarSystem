package ru.solarsystem.model.planets;

import ru.solarsystem.model.satellite.Satellite;

import java.util.List;

public interface PlanetInterface {

    public String getName();
    public long getDistance();

    default public List<Satellite> getSat() {return null;}

}
