package com.harun.series.SeriesList.service;

import com.harun.series.Serie.models.Series;
import com.harun.series.Serie.repositories.SeriesRepository;
import com.harun.series.SeriesList.DTO.SeriesListDTO;
import com.harun.series.SeriesList.SeriesListMapper;
import com.harun.series.SeriesList.models.SeriesList;
import com.harun.series.SeriesList.repository.SeriesListRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class SeriesListServiceImpl implements SeriesListService{

    private final SeriesListRepository seriesListRepository;
    private final SeriesRepository seriesRepository;

    @Override
    public SeriesListDTO create(String name) {
        if (seriesListRepository.existsByName(name)) {
            throw new IllegalArgumentException("List with name '" + name + "' already exists");
        }

        SeriesList list = new SeriesList();
        list.setName(name);

        return SeriesListMapper.toDto(seriesListRepository.save(list));
    }

    @Override
    public SeriesListDTO getById(Long id) {
        SeriesList list = seriesListRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Series list not found with id " + id));

        return SeriesListMapper.toDto(list);
    }

    @Override
    public List<SeriesListDTO> getAll() {
        List <SeriesList> list = seriesListRepository.findAll();
        return list.stream().map(SeriesListMapper::toDto).toList();
    }

    @Override
    public SeriesListDTO addSeries(Long listId, String seriesPublicId) {
        SeriesList list = seriesListRepository.findById(listId)
                .orElseThrow(() -> new RuntimeException("Series list not found with id " + listId));

        Series series = seriesRepository.findByPublicId(seriesPublicId)
                .orElseThrow(() -> new RuntimeException("Series not found with id " + seriesPublicId));

        list.getSeries().add(series);

        return SeriesListMapper.toDto(seriesListRepository.save(list));
    }

    @Override
    public SeriesListDTO removeSeries(Long listId, String seriesPublicId) {
        SeriesList list = seriesListRepository.findById(listId)
                .orElseThrow(() -> new RuntimeException("Series list not found with id " + listId));

        Series series = seriesRepository.findByPublicId(seriesPublicId)
                .orElseThrow(() -> new RuntimeException("Series not found with id " + seriesPublicId));

        list.getSeries().remove(series);
        return SeriesListMapper.toDto(seriesListRepository.save(list));
    }

    @Override
    public void delete(Long id) {
        if (!seriesListRepository.existsById(id)) {
            throw new RuntimeException("Series list not found with id " + id);
        }
        seriesListRepository.deleteById(id);
    }
}
