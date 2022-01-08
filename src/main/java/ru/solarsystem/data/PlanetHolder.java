package ru.solarsystem.data;

import ru.solarsystem.model.planets.Planet;

/**
 * способ захаркодить все планеты
 */
// TODO: добавить спутники
public enum PlanetHolder {
    Mercury(new Planet("Меркурий",
            58_000_000,
            88,
            4879,
            null)),
    Venus(new Planet("Венера",
            108_000_000,
            225,
            12_100,
            null)),
    Earth(new Planet("Земля",
            149_000_000,
            365,
            12_742,
            null)),
    Mars(new Planet("Марс",
            228_000_000,
            687,
            6792,
            null)),
    Jupiter(new Planet("Юпитер",
            778_000_000,
            4332,
            143_884,
            null)),
    Saturn(new Planet("Сатурн",
            1_430_000_000,
            10_759,
            120_536,
            null)),
    Uranium(new Planet("Уран",
            2800000000L,
            30685,
            50724,
            null)),
    Neptune(new Planet("Нептун",
            4_500_000_000L,
            60190,
            49244,
            null));

    private Planet planet;

    PlanetHolder(Planet planet) {
        this.planet = planet;
    }
}
