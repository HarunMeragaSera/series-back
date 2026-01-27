package com.harun.series.Genre.dto;

import jakarta.validation.constraints.NotBlank;

public class GenreDto {

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Name in spanish is mandatory")
    private String name_es;

    // Constructor vacío
    public GenreDto() { }

    // Constructor con nombre
    public GenreDto(String name,String name_es) {

        this.name = name;
        this.name_es = name_es;
    }

    // Getter y Setter
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
}