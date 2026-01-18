package com.harun.series.Serie.models;

import com.harun.series.Serie.enums.Rating;
import jakarta.persistence.*;

@Entity
@Table(name = "series")
public class Series {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 200)
    private String name;

    @Enumerated(EnumType.STRING)
    private Rating rating;

    @Column (name = "image_url", length = 500)
    private String imageUrl;

    @Column(name = "year_watch")
    private Integer yearWatch;

    public Series() {
    }

    public Series(String name, Rating rating, String imageUrl, Integer yearWatch) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.imageUrl = imageUrl;
        this.yearWatch = yearWatch;
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
}
