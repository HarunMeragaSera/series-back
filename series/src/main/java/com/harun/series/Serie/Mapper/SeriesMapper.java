package com.harun.series.Serie.Mapper;

import com.harun.series.Genre.models.Genre;
import com.harun.series.Serie.Dto.SeriesDto;
import com.harun.series.Serie.models.Series;

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
}
