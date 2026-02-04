package com.harun.series.SeriesList;

import com.harun.series.Serie.Mapper.SeriesMapper;
import com.harun.series.SeriesList.DTO.SeriesListDTO;
import com.harun.series.SeriesList.models.SeriesList;


import java.util.stream.Collectors;

public class SeriesListMapper {

    private SeriesListMapper() {}

    public static SeriesListDTO toDto(SeriesList entity) {
        if (entity == null) {
            return null;
        }

        return new SeriesListDTO(
                entity.getId(),
                entity.getName(),
                entity.getSeries()
                        .stream()
                        .map(SeriesMapper::toDto)
                        .collect(Collectors.toList())
        );
    }

}
