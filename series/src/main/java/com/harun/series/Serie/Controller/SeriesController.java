package com.harun.series.Serie.Controller;

import com.harun.series.Exceptions.SeriesAlreadyExistsException;
import com.harun.series.Serie.Dto.SeriesCreateDTO;
import com.harun.series.Serie.Dto.SeriesDto;
import com.harun.series.Serie.Dto.SeriesFilterDTO;
import com.harun.series.Serie.Service.SeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/series")
public class SeriesController {

    private final SeriesService seriesService;

    @Autowired
    public SeriesController(SeriesService seriesService){
        this.seriesService = seriesService;
    }

    @PostMapping
    public ResponseEntity<?> createSeries(@RequestBody @Validated SeriesCreateDTO series) throws SeriesAlreadyExistsException {
        SeriesDto savedSeries = seriesService.save(series);
        return new ResponseEntity<>(savedSeries, HttpStatus.CREATED);
    }

    @GetMapping("/{publicId}")
    public SeriesDto getByPublicId(@PathVariable String publicId) {
        return seriesService.getByPublicId(publicId);
    }

        @GetMapping()
        public List<SeriesDto> findAll(SeriesFilterDTO filter){
            return seriesService.findAll(filter);
        }

    @DeleteMapping("/{publicId}")
    public void deleteById(@PathVariable("publicId") String publicId){
        seriesService.deleteByPublicId(publicId);
    }

    @PostMapping("/{publicId}")
    public SeriesDto update(@PathVariable("publicId") String publicId,@RequestBody @Validated SeriesCreateDTO series){
        return seriesService.update(publicId,series);
    }
}
