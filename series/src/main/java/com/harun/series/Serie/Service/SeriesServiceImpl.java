package com.harun.series.Serie.Service;

import com.harun.series.Exceptions.SeriesAlreadyExistsException;
import com.harun.series.Exceptions.SeriesNotFoundException;
import com.harun.series.Genre.models.Genre;
import com.harun.series.Serie.Dto.SeriesDto;
import com.harun.series.Serie.Mapper.SeriesMapper;
import com.harun.series.Serie.models.Series;
import com.harun.series.Serie.repositories.SeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class SeriesServiceImpl implements SeriesService{


    private final SeriesRepository seriesRepository;
    @Autowired
    public SeriesServiceImpl(SeriesRepository seriesRepository) {
        this.seriesRepository = seriesRepository;
    }

    @Override
    public List<SeriesDto> findAll() {
        return seriesRepository.findAll()
                .stream()
                .map(SeriesMapper::toDto)
                .toList();
    }

    @Override
    public SeriesDto save(SeriesDto seriesDto) throws SeriesAlreadyExistsException {
        if(existsByName(seriesDto.getName())){
            throw new SeriesAlreadyExistsException(seriesDto.getName());
        }

        return SeriesMapper.toDto(seriesRepository.save(SeriesMapper.seriesDtoToSeries(seriesDto)));
    }

    @Override
    public SeriesDto update(Long id, SeriesDto seriesDto) {
        if(existsByName(seriesDto.getName())){
            throw new SeriesAlreadyExistsException(seriesDto.getName());
        }
        Series serieFounded = seriesRepository.findById(id).orElseThrow(() -> new SeriesNotFoundException(id));
        return SeriesMapper.toDto(seriesRepository.save(SeriesMapper.dtoAndSeriesToSeries(seriesDto,serieFounded)));
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
