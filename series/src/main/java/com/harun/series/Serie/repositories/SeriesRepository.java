package com.harun.series.Serie.repositories;

import com.harun.series.Serie.models.Series;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SeriesRepository extends CrudRepository<Series,Long> {
    Optional<Series>findByName(String name);
}
