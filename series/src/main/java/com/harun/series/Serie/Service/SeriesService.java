package com.harun.series.Serie.Service;

import com.harun.series.Serie.Dto.SeriesCreateDTO;
import com.harun.series.Serie.Dto.SeriesDto;
import com.harun.series.Serie.models.Series;

import java.util.List;
import java.util.Optional;

public interface SeriesService{
    List<SeriesDto> findAll();
    SeriesDto save(SeriesCreateDTO series);
    SeriesDto update(Long id, SeriesDto seriesDto);
    SeriesDto getByPublicId(String publicId);
    void deleteById(Long id);
}
