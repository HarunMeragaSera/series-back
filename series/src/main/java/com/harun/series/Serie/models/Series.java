package com.harun.series.Serie.models;

import com.harun.series.Genre.models.Genre;
import com.harun.series.Serie.enums.Rating;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "series")
public class Series {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, updatable = false)
    private String publicId;

    @Column(nullable = false,length = 200)
    private String name;

    @Enumerated(EnumType.STRING)
    private Rating rating;

    @Column (name = "image_url", length = 500)
    private String imageUrl;

    @Column(name = "year_watch")
    private Integer yearWatch;

    @Column(length = 2000)
    private String description;

    @ManyToMany
    @JoinTable(
            name = "series_genres",
            joinColumns = @JoinColumn(name = "series_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private Set<Genre> genres = new HashSet<>();

    @PrePersist
    public void generatePublicId() {
        if (publicId == null) {
            publicId = UUID.randomUUID().toString();
        }
    }

    public Series() {
    }

    public Series(String name, Rating rating, String imageUrl, Integer yearWatch,String description) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.imageUrl = imageUrl;
        this.yearWatch = yearWatch;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Rating getRating() {
        return rating;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getYearWatch() {
        return yearWatch;
    }

    public void setYearWatch(Integer yearWatch) {
        this.yearWatch = yearWatch;
    }

    public String getPublicId() {
        return publicId;
    }

    public void setPublicId(String publicId) {
        this.publicId = publicId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Genre> getGenres() { return genres; }
    public void setGenres(Set<Genre> genres) { this.genres = genres; }
}
