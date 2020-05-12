package com.capgemini.movies.mappers;

import com.capgemini.movies.dto.MovieDetailsDto;
import com.capgemini.movies.models.Movie;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class MovieMapper {
    public MovieDetailsDto toDto(Movie movie) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(movie, MovieDetailsDto.class);
    }
}
