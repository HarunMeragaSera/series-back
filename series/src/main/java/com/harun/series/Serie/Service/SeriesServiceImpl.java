package com.harun.series.Serie.Service;

import com.harun.series.Exceptions.SeriesAlreadyExistsException;
import com.harun.series.Exceptions.SeriesNotFoundException;
import com.harun.series.Genre.models.Genre;
import com.harun.series.Genre.repository.GenreRepository;
import com.harun.series.Serie.Dto.SeriesCreateDTO;
import com.harun.series.Serie.Dto.SeriesDto;
import com.harun.series.Serie.Mapper.SeriesMapper;
import com.harun.series.Serie.models.Series;
import com.harun.series.Serie.repositories.SeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;

@Service
public class SeriesServiceImpl implements SeriesService{


    private final SeriesRepository seriesRepository;
    private final GenreRepository genreRepository;
    @Autowired
    public SeriesServiceImpl(SeriesRepository seriesRepository,GenreRepository genreRepository) {
        this.seriesRepository = seriesRepository;
        this.genreRepository = genreRepository;
    }

    @Override
    public List<SeriesDto> findAll() {
        return seriesRepository.findAll()
                .stream()
                .map(SeriesMapper::toDto)
                .toList();
    }

    @Override
    public SeriesDto save(SeriesCreateDTO dto) throws SeriesAlreadyExistsException {
        if(existsByName(dto.getName())){
            throw new SeriesAlreadyExistsException(dto.getName());
        }
        Set<Genre> genres = new HashSet<>();
        if (dto.getGenreIds() != null && !dto.getGenreIds().isEmpty()) {
            genres.addAll(genreRepository.findAllById(dto.getGenreIds()));
        }

        Series series = SeriesMapper.seriesCreateDto_toEntity(dto, genres);

        return SeriesMapper.toDto(seriesRepository.save(series));
    }

    @Override
    public SeriesDto update(String publicId, SeriesCreateDTO dto) {
        Series serieFounded = seriesRepository.findByPublicId(publicId).orElseThrow(() -> new SeriesNotFoundException(publicId));
        Set<Genre> genres = new HashSet<>(genreRepository.findAllById(dto.getGenreIds()));
        Series serie = SeriesMapper.dtoAndSeriesToSeries(dto,serieFounded,genres);
        return SeriesMapper.toDto(seriesRepository.save(serie));
    }

    @Override
    public void deleteById(Long id) {
        Series serieFounded = seriesRepository.findById(id).orElseThrow(() -> new SeriesNotFoundException(id));
        seriesRepository.deleteById(id);

    }
    @Override
    public SeriesDto getByPublicId(String publicId) {
        Series series = seriesRepository.findByPublicId(publicId).orElseThrow(() -> new SeriesNotFoundException(publicId));
        series.getGenres().stream()
                .forEach( genre -> System.out.println(genre.getName()));
        return SeriesMapper.toDto(series);
    }

    public boolean existsByName(String name) {
        return seriesRepository.findByName(name).isPresent();
    }
}
