package com.harun.series.Serie.Mapper;

import com.harun.series.Serie.Dto.SeriesDto;
import com.harun.series.Serie.models.Series;

public class SeriesMapper {

    public static Series seriesDtoToSeries(SeriesDto dto){
        return new Series(dto.getName(),dto.getRating());
    }
}
