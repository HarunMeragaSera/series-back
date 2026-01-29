package com.harun.series.Serie.Dto;

import com.harun.series.Serie.enums.Rating;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

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
    private String description;
    private String publicId;
    private List<Long> genres;

    public SeriesDto(String name, Rating rating, Integer yearWatch) {
        this.name = name;
        this.rating = rating;
        this.yearWatch = yearWatch;

    }

    public SeriesDto(String name, Rating rating,String imageUrl,Integer yearWatch,String publicId,String description,List<Long> genres) {
        this.name = name;
        this.rating = rating;
        this.imageUrl = imageUrl;
        this.yearWatch = yearWatch;
        this.publicId = publicId;
        this.description = description;
        this.genres = genres;
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

    public List<Long> getGenres() {
        return genres;
    }

    public void setGenres(List<Long> genres) {
        this.genres = genres;
    }
}
