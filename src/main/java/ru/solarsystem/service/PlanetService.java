package ru.solarsystem.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.solarsystem.data.PlanetRepo;
import ru.solarsystem.model.MessageDto;
import ru.solarsystem.model.Planet;
import ru.solarsystem.model.Satellite;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PlanetService {

    private final PlanetRepo repository;

    @Autowired
    public PlanetService(PlanetRepo repository) {
        this.repository = repository;
    }

    public long getMinPlanetsDistance(Planet planet1, Planet planet2) {
        return Math.abs(planet1.getDistanceToSun() - planet2.getDistanceToSun());
    }

    public long getMaximumPlanetDistance(Planet planet1, Planet planet2) {
         return Math.abs(planet1.getDistanceToSun() + planet2.getDistanceToSun());
    }

    public List<Satellite> getSatellites(Planet planet) {
        return planet.getSatellites();
    }

    public List<Planet> findAllPlanets() {
        return repository.findAll();
    }


    public Planet findPlanetByName(String name) {
        return repository.findByName(name);
    }

    public Planet findByIndex(int index) {return repository.findById(index).orElse(null);
    }

    public double numberRotationPlanet(Planet planet, int days) {
        double numberRotation = (double) days/planet.getYearDuration();

        if (numberRotation > 0) {
            return numberRotation;
        }
        return 0;
    }

    public double compareSizePlanets(Planet planet1, Planet planet2) {
        return (double) planet1.getDiameter()/planet2.getDiameter();
    }


    public HashMap<String, String> mapRealValue(MessageDto message, HashMap<String, String> mapKey, HashMap<String, String> mapClean) throws JsonProcessingException {

        String messageToStringJson = new ObjectMapper().writeValueAsString(message);

        List<String> listMessage = Arrays.asList(messageToStringJson.split("[\":},{]")).stream().filter(item -> !item.equals("")).collect(Collectors.toList());

        for (Map.Entry<String, String> mapKeyObj : mapKey.entrySet()) {
            for (Map.Entry<String, String> mapCleanMarker : mapClean.entrySet()) {

                if (mapKeyObj.getKey().equalsIgnoreCase(mapCleanMarker.getKey())) {

                    List<String> subListMessage = listMessage.subList(listMessage.indexOf(mapKeyObj.getValue()), listMessage.size());
                    int x = subListMessage.indexOf(mapCleanMarker.getValue()) + 1;

                    mapClean.put(mapCleanMarker.getKey(), subListMessage.get(x));
                }
            }
        }

        for (Map.Entry<String, String> mapCleanMarker : mapClean.entrySet()) {

            if (listMessage.indexOf(mapCleanMarker.getValue()) != -1 && !mapKey.containsKey(mapCleanMarker.getKey())) {
                mapClean.put(mapCleanMarker.getKey(), listMessage.get(listMessage.indexOf(mapCleanMarker.getValue()) + 1));

            }
        }

        return mapClean;
    }

}
