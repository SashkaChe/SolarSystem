package ru.solarsystem.data.enum_provider;

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
        List<Satellite> satellites = new ArrayList<>();
            satellites.add(SatelliteHolder.Moon.satellite);
        return satellites;
        }

        public static List<Satellite> getMarsSatellites() {
        List<Satellite> satellites = new ArrayList<>();
            satellites.add(SatelliteHolder.Fobos.satellite);
            satellites.add(SatelliteHolder.Deimos.satellite);
        return satellites;
        }

        public static List<Satellite> getJupiterSatellites() {
        List<Satellite> satellites = new ArrayList<>();
            satellites.add(SatelliteHolder.Io.satellite);
            satellites.add(SatelliteHolder.Ganymede.satellite);
            satellites.add(SatelliteHolder.Callisto.satellite);
            satellites.add(SatelliteHolder.Europe.satellite);
        return satellites;
        }

        public static List<Satellite> getSaturnSatellites() {
        List<Satellite> satellites = new ArrayList<>();
            satellites.add(SatelliteHolder.Titan.satellite);
            satellites.add(SatelliteHolder.Yapet.satellite);
            satellites.add(SatelliteHolder.Diona.satellite);
            satellites.add(SatelliteHolder.Rhea.satellite);
            satellites.add(SatelliteHolder.Tefiya.satellite);
        return satellites;
        }

        public static List<Satellite> getUraniumSatellites() {
        List<Satellite> satellites = new ArrayList<>();
            satellites.add(SatelliteHolder.Ariel.satellite);
            satellites.add(SatelliteHolder.Miranda.satellite);
            satellites.add(SatelliteHolder.Titaniya.satellite);
            satellites.add(SatelliteHolder.Oberon.satellite);
            satellites.add(SatelliteHolder.Umbriel.satellite);
        return satellites;
        }

        public static List<Satellite> getNeptuneSatellites() {
        List<Satellite> satellites = new ArrayList<>();
            satellites.add(SatelliteHolder.Triton.satellite);
        return satellites;
        }

        }