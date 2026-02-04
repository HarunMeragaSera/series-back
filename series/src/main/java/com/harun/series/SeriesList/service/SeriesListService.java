package com.harun.series.SeriesList.service;


import com.harun.series.SeriesList.DTO.SeriesListDTO;
import com.harun.series.SeriesList.models.SeriesList;

import java.util.List;

public interface SeriesListService {

    SeriesListDTO create(String name);

    SeriesListDTO getById(Long id);

    List<SeriesListDTO> getAll();

    SeriesListDTO addSeries(Long listId, String seriesPublicId);

    SeriesListDTO removeSeries(Long listId, String seriesPublicId);

    void delete(Long id);
}
