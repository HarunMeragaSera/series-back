package com.harun.series.SeriesList.controller;

import com.harun.series.SeriesList.DTO.SeriesListDTO;
import com.harun.series.SeriesList.service.SeriesListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/series-lists")
@RequiredArgsConstructor
public class SeriesListController {

    private final SeriesListService seriesListService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SeriesListDTO create(@RequestParam String name) {
        return seriesListService.create(name);
    }

    @GetMapping("/{id}")
    public SeriesListDTO getById(@PathVariable Long id) {
        return seriesListService.getById(id);
    }

    @GetMapping
    public List<SeriesListDTO> getAll() {
        return seriesListService.getAll();
    }

    @PostMapping("/{listId}/series/{seriesPublicId}")
    public SeriesListDTO addSeries(
            @PathVariable Long listId,
            @PathVariable String seriesPublicId
    ) {
        return seriesListService.addSeries(listId, seriesPublicId);
    }

    @DeleteMapping("/{listId}/series/{seriesPublicId}")
    public SeriesListDTO removeSeries(
            @PathVariable Long listId,
            @PathVariable String seriesPublicId
    ) {
        return seriesListService.removeSeries(listId, seriesPublicId);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        seriesListService.delete(id);
    }
}
