package com.harun.series.Serie.Dto;

import com.harun.series.Serie.enums.Rating;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class SeriesDto {
    @NotBlank(message = "Series name is mandatory")
    private String name;
    @NotNull(message = "Series rating is mandatory")
    private Rating rating;

    public SeriesDto(String name, Rating rating) {
        this.name = name;
        this.rating = rating;
    }

    public SeriesDto(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }
}
