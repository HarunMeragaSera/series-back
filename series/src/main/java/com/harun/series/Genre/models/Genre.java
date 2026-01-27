package com.harun.series.Genre.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.harun.series.Serie.models.Series;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "genre")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String name_es;

    @ManyToMany(mappedBy = "genres")
    @JsonIgnore
    private Set<Series> series = new HashSet<>();

    public Genre() {
    }

    public Genre(String name,String name_es) {

        this.name = name;
        this.name_es = name_es;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName_es() {
        return name_es;
    }

    public void setName_es(String name_es) {
        this.name_es = name_es;
    }

    public Set<Series> getSeries() { return series; }
    public void setSeries(Set<Series> series) { this.series = series; }
}