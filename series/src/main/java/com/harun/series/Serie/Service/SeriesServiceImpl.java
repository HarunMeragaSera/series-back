package com.harun.series.Serie.Service;

import com.harun.series.Exceptions.SeriesAlreadyExistsException;
import com.harun.series.Exceptions.SeriesNotFoundException;
import com.harun.series.Serie.Dto.SeriesDto;
import com.harun.series.Serie.Mapper.SeriesMapper;
import com.harun.series.Serie.models.Series;
import com.harun.series.Serie.repositories.SeriesRepository;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeriesServiceImpl implements SeriesService{


    private final SeriesRepository seriesRepository;
    @Autowired
    public SeriesServiceImpl(SeriesRepository seriesRepository) {
        this.seriesRepository = seriesRepository;
    }

    @Override
    public List<Series> findAll() {
        return (List<Series>) this.seriesRepository.findAll();
    }

    @Override
    public Series findById(Long id) throws SeriesNotFoundException{
        return seriesRepository.findById(id).orElseThrow(() -> new SeriesNotFoundException(id));
    }

    @Override
    public Series save(SeriesDto seriesDto) throws SeriesAlreadyExistsException {
        if(existsByName(seriesDto.getName())){
            throw new SeriesAlreadyExistsException(seriesDto.getName());
        }

        return seriesRepository.save(SeriesMapper.seriesDtoToSeries(seriesDto));
    }

    @Override
    public Series update(Long id, Series series) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    public boolean existsByName(String name) {
        return seriesRepository.findByName(name).isPresent();
    }
}
