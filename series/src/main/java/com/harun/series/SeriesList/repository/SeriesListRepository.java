package com.harun.series.SeriesList.repository;

import com.harun.series.SeriesList.models.SeriesList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SeriesListRepository extends JpaRepository<SeriesList, Long> {

    Optional<SeriesList> findByName(String name);
    boolean existsByName(String name);
}
