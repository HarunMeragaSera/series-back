package com.harun.series.SeriesList.DTO;

import com.harun.series.Serie.Dto.SeriesDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SeriesListDTO {
    private Long id;
    private String name;
    private List<SeriesDto> series;

    public SeriesListDTO(Long id, String name, List<SeriesDto> series) {
        this.id = id;
        this.name = name;
        this.series = series;
    }

    public SeriesListDTO() {
    }
}
