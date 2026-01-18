package com.harun.series.Exceptions;

public class SeriesNotFoundException extends RuntimeException {
    public SeriesNotFoundException(Long id) {

        super("Series with ID: "+id+" not found");
    }

    public SeriesNotFoundException(String id) {

        super("Series with Public ID: "+id+" not found");
    }
}
