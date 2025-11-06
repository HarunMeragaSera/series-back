package com.harun.series.Serie.Controller;

import com.harun.series.Exceptions.SeriesAlreadyExistsException;
import com.harun.series.Serie.Dto.SeriesDto;
import com.harun.series.Serie.Service.SeriesService;
import com.harun.series.Serie.models.Series;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/series")
public class SeriesController {

    private final SeriesService seriesService;

    @Autowired
    public SeriesController(SeriesService seriesService){
        this.seriesService = seriesService;
    }

    @PostMapping
    public ResponseEntity<?> createSeries(@RequestBody @Validated SeriesDto series) throws SeriesAlreadyExistsException {
        Series savedSeries = seriesService.save(series);
        return new ResponseEntity<>(savedSeries, HttpStatus.CREATED);
    }
}
