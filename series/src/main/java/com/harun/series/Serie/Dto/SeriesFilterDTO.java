package com.harun.series.Serie.Dto;

import com.harun.series.Serie.enums.Rating;

import java.util.List;

public class SeriesFilterDTO {

    private Rating rating;
    private Integer yearFrom;
    private Integer yearTo;
    private List<Long> genres;

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public Integer getYearFrom() {
        return yearFrom;
    }

    public void setYearFrom(Integer yearFrom) {
        this.yearFrom = yearFrom;
    }

    public Integer getYearTo() {
        return yearTo;
    }

    public void setYearTo(Integer yearTo) {
        this.yearTo = yearTo;
    }

    public List<Long> getGenres() {
        return genres;
    }

    public void setGenres(List<Long> genres) {
        this.genres = genres;
    }
}
