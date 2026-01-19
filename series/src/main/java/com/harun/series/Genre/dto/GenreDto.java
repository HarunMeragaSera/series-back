package com.harun.series.Genre.dto;

import jakarta.validation.constraints.NotBlank;

public class GenreDto {

    @NotBlank(message = "Name is mandatory")
    private String name;

    // Constructor vacío
    public GenreDto() { }

    // Constructor con nombre
    public GenreDto(String name) {
        this.name = name;
    }

    // Getter y Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}