package com.harun.series.Serie.repositories;

import com.harun.series.Serie.models.Series;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SeriesRepository extends JpaRepository<Series,Long>, JpaSpecificationExecutor<Series> {
    Optional<Series>findByName(String name);
    Optional<Series> findByPublicId(String publicId);
    void deleteByPublicId(String publicId);
}
