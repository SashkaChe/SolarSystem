package ru.solarsystem.data;

import ru.solarsystem.model.Satellite;

import java.util.ArrayList;
import java.util.List;

public enum SatelliteHolder {
            Ariel(new Satellite("Ариэль")),
            Callisto(new Satellite("Каллисто")),
            Deimos(new Satellite("Деймос")),
            Diona(new Satellite("Диона")),
            Europe(new Satellite("Европа")),
            Fobos(new Satellite("Фобос")),
            Ganymede(new Satellite("Ганимед")),
            Io(new Satellite("Ио")),
            Miranda(new Satellite("Миранда")),
            Moon(new Satellite("Луна")),
            Oberon(new Satellite("Оберон")),
            Rhea(new Satellite("Рея")),
            Tefiya(new Satellite("Тефия")),
            Titan(new Satellite("Титан")),
            Titaniya(new Satellite("Титания")),
            Triton(new Satellite("Тритон")),
            Umbriel(new Satellite("Умбриэль")),
            Yapet(new Satellite("Япет"));


    private Satellite satellite;

        SatelliteHolder (Satellite satellite) {
        this.satellite = satellite;
        }

        public Satellite getSatellite() {
        return satellite;
        }

        public static List<Satellite> getMercurySatellites() {
        return null;
        }

        public static List<Satellite> getVenusSatellites() {
        return null;
        }

        public static List<Satellite> getEarthSatellites() {
        List<Satellite> satellite = new ArrayList<>();
        satellite.add(SatelliteHolder.Moon.satellite);
        return satellite;
        }

        public static List<Satellite> getMarsSatellites() {
        List<Satellite> satellite = new ArrayList<>();
        satellite.add(SatelliteHolder.Fobos.satellite);
        satellite.add(SatelliteHolder.Deimos.satellite);
        return satellite;
        }

        public static List<Satellite> getJupiterSatellites() {
        List<Satellite> satellite = new ArrayList<>();
        satellite.add(SatelliteHolder.Io.satellite);
        satellite.add(SatelliteHolder.Ganymede.satellite);
        satellite.add(SatelliteHolder.Callisto.satellite);
        satellite.add(SatelliteHolder.Europe.satellite);
        return satellite;
        }

        public static List<Satellite> getSaturnSatellites() {
        List<Satellite> satellite = new ArrayList<>();
        satellite.add(SatelliteHolder.Titan.satellite);
        satellite.add(SatelliteHolder.Yapet.satellite);
        satellite.add(SatelliteHolder.Diona.satellite);
        satellite.add(SatelliteHolder.Rhea.satellite);
        satellite.add(SatelliteHolder.Tefiya.satellite);
        return satellite;
        }

        public static List<Satellite> getUraniumSatellites() {
        List<Satellite> satellite = new ArrayList<>();
        satellite.add(SatelliteHolder.Ariel.satellite);
        satellite.add(SatelliteHolder.Miranda.satellite);
        satellite.add(SatelliteHolder.Titaniya.satellite);
        satellite.add(SatelliteHolder.Oberon.satellite);
        satellite.add(SatelliteHolder.Umbriel.satellite);
        return satellite;
        }

        public static List<Satellite> getNeptuneSatellites() {
        List<Satellite> satellite = new ArrayList<>();
        satellite.add(SatelliteHolder.Triton.satellite);
        return satellite;
        }

        }