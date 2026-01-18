package com.harun.series.Serie.Dto;

import com.harun.series.Serie.enums.Rating;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class SeriesDto {
    @NotBlank(message = "Series name is mandatory")
    @Size(max = 200,message = "Name must be at most 200 characters long")
    private String name;
    @NotNull(message = "Series rating is mandatory")
    private Rating rating;
    @Size(max = 500,message = "Image url must be at most 500 characters long")
    private String imageUrl;
    @NotNull(message = "Year is mandatory")
    private Integer yearWatch;

    public SeriesDto(String name, Rating rating, Integer yearWatch) {
        this.name = name;
        this.rating = rating;
        this.yearWatch = yearWatch;
    }

    public SeriesDto(String name, Rating rating,String imageUrl,Integer yearWatch) {
        this.name = name;
        this.rating = rating;
        this.imageUrl = imageUrl;
        this.yearWatch = yearWatch;
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
