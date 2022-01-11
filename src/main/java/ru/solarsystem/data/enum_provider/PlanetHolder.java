package ru.solarsystem.data.enum_provider;

import ru.solarsystem.model.Planet;

/**
 * способ захаркодить все планеты
 */
// TODO: добавить спутники
public enum PlanetHolder {
    Mercury(new Planet("Меркурий",
            58_000_000,
            88,
            4879,
            SatelliteHolder.getMercurySatellites())),
    Venus(new Planet("Венера",
            108_000_000,
            225,
            12_100,
            SatelliteHolder.getVenusSatellites())),
    Earth(new Planet("Земля",
            149_000_000,
            365,
            12_742,
            SatelliteHolder.getEarthSatellites())),
    Mars(new Planet("Марс",
            228_000_000,
            687,
            6792,
            SatelliteHolder.getMarsSatellites())),
    Jupiter(new Planet("Юпитер",
            778_000_000,
            4332,
            143_884,
            SatelliteHolder.getJupiterSatellites())),
    Saturn(new Planet("Сатурн",
            1_430_000_000,
            10_759,
            120_536,
            SatelliteHolder.getSaturnSatellites())),
    Uranium(new Planet("Уран",
            2800000000L,
            30685,
            50724,
            SatelliteHolder.getUraniumSatellites())),
    Neptune(new Planet("Нептун",
            4_500_000_000L,
            60190,
            49244,
            SatelliteHolder.getNeptuneSatellites()));

    private Planet planet;

    PlanetHolder(Planet planet) {
        this.planet = planet;
    }

    public Planet getPlanet() {
        return planet;
    }
}
