package com.harun.series.Serie.specifications;

import com.harun.series.Genre.models.Genre;
import com.harun.series.Serie.enums.Rating;
import com.harun.series.Serie.models.Series;
import jakarta.persistence.criteria.Join;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class SeriesSpecifications {

    public static Specification<Series> hasRating(Rating rating) {
        return (root, query, cb) ->
                cb.equal(root.get("rating"), rating);
    }

    public static Specification<Series> yearEqual(Integer year) {
        return (root, query, cb) ->
                cb.equal(root.get("yearWatch"), year);
    }

    public static Specification<Series> hasGenres(List<Long> genreIds) {
        return (root, query, cb) -> {
            query.distinct(true);
            Join<Series, Genre> genres = root.join("genres");
            return genres.get("id").in(genreIds);
        };
    }

    public static Specification<Series> likeName(String name) {
        return (root, query, cb) ->
                cb.like(
                        cb.lower(root.get("name")),
                        "%" + name.toLowerCase().trim() + "%"
                );
    }
}
