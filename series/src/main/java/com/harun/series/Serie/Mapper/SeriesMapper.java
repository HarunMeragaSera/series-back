package com.harun.series.Serie.Mapper;

import com.harun.series.Genre.models.Genre;
import com.harun.series.Serie.Dto.SeriesCreateDTO;
import com.harun.series.Serie.Dto.SeriesDto;
import com.harun.series.Serie.models.Series;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public class SeriesMapper {

    public static Series seriesDtoToSeries(SeriesDto dto){
        return new Series(dto.getName(),dto.getRating(),dto.getImageUrl(),dto.getYearWatch(),dto.getDescription());
    }
    public static Series dtoAndSeriesToSeries(SeriesDto dto, Series series){
        series.setName(dto.getName());
        series.setRating(dto.getRating());
        series.setImageUrl(dto.getImageUrl());
        return series;
    }

    public static SeriesDto toDto(Series series) {
        return new SeriesDto(
            series.getName(),
            series.getRating(),
            series.getImageUrl(),
            series.getYearWatch(),
            series.getPublicId(),
            series.getDescription(),
            series.getGenres().stream()
                        .map(Genre::getName)
                        .toList()
        );
    }

    public static Series seriesCreateDto_toEntity(SeriesCreateDTO dto, Set<Genre> genres) {

        Series series = new Series();

        series.setPublicId(UUID.randomUUID().toString());
        series.setName(dto.getName());
        series.setRating(dto.getRating());
        series.setImageUrl(dto.getImageUrl());
        series.setYearWatch(dto.getYearWatch());
        series.setDescription(dto.getDescription());
        series.setGenres(genres);

        return series;
    }

    public SeriesCreateDTO entityToCreateDto(Series series) {

        SeriesCreateDTO dto = new SeriesCreateDTO();

        dto.setName(series.getName());
        dto.setRating(series.getRating());
        dto.setImageUrl(series.getImageUrl());
        dto.setYearWatch(series.getYearWatch());
        dto.setDescription(series.getDescription());

        if (series.getGenres() != null) {
            dto.setGenreIds(
                    series.getGenres().stream()
                            .map(Genre::getId)
                            .collect(Collectors.toSet())
            );
        }

        return dto;
    }
}
