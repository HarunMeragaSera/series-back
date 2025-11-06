package com.harun.series.Serie.Service;

import com.harun.series.Serie.Dto.SeriesDto;
import com.harun.series.Serie.models.Series;

import java.util.List;
import java.util.Optional;

public interface SeriesService{
    List<Series> findAll();
    Optional<Series> findById();
    Series save(SeriesDto series);
    Series update(Long id, Series series);
    void deleteById(Long id);
}
