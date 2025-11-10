package com.harun.series.Exceptions;

public class SeriesNotFoundException extends RuntimeException {
    public SeriesNotFoundException(Long id) {

        super("Series with ID: "+id+" not found");
    }
}
