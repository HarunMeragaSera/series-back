package com.harun.series.Genre.mapper;

import com.harun.series.Genre.dto.GenreDto;
import com.harun.series.Genre.models.Genre;

public class GenreMapper {

    public static GenreDto toDTO(Genre genre) {
        if (genre == null) return null;
        return new GenreDto(genre.getName());
    }

    public static Genre toEntity(GenreDto genreDTO) {
        if (genreDTO == null) return null;
        return new Genre(genreDTO.getName());
    }
}
