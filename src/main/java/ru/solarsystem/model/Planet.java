package ru.solarsystem.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Builder
@AllArgsConstructor
@Entity
@Table(name = "planets")
public class Planet {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "distanceToSun")
    private long distanceToSun;

    /** продолжительность года в (земных) сутках      */

    @Column(name = "yearDuration")
    private int yearDuration;

    @Column(name = "diameter")
    private int diameter;


    @OneToMany(mappedBy = "planet", cascade=CascadeType.ALL, orphanRemoval=true)
    private List<Satellite> satellites;

}
