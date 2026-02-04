package com.harun.series.SeriesList.models;

import com.harun.series.Serie.models.Series;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "series_lists")
public class SeriesList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String name;

    @ManyToMany
    @JoinTable(
            name = "series_list_series",
            joinColumns = @JoinColumn(name = "list_id"),
            inverseJoinColumns = @JoinColumn(name = "series_id")
    )
    private Set<Series> series = new HashSet<>();

    public SeriesList(Long id, String name, Set<Series> series) {
        this.id = id;
        this.name = name;
        this.series = series;
    }

    public SeriesList(){}

}