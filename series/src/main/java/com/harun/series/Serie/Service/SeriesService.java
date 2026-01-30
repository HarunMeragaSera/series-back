package com.harun.series.Serie.Service;

import com.harun.series.Serie.Dto.SeriesCreateDTO;
import com.harun.series.Serie.Dto.SeriesDto;
import com.harun.series.Serie.Dto.SeriesFilterDTO;
import com.harun.series.Serie.models.Series;

import java.util.List;
import java.util.Optional;

public interface SeriesService{
    List<SeriesDto> findAll(SeriesFilterDTO filter);
    SeriesDto save(SeriesCreateDTO series);
    SeriesDto update(String publicId, SeriesCreateDTO dto);
    SeriesDto getByPublicId(String publicId);
    void deleteById(Long id);
}
