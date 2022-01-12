package ru.solarsystem.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class Planet {
    // TODO add constrains for positive values

    private String name;
    private long distanceToSun;
    /** продолжительность года в (земных) сутках      */
    private int yearDuration;
    private int diameter;

    private List<Satellite> satellites;

}