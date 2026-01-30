package com.harun.series.Serie.Dto;

import com.harun.series.Serie.enums.Rating;

import java.util.List;

public class SeriesFilterDTO {

    private Rating rating;
    private Integer yearWatch;
    private List<Long> genres;

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public List<Long> getGenres() {
        return genres;
    }

    public void setGenres(List<Long> genres) {
        this.genres = genres;
    }

    public Integer getYearWatch() {
        return yearWatch;
    }

    public void setYearWatch(Integer yearWatch) {
        this.yearWatch = yearWatch;
    }
}
