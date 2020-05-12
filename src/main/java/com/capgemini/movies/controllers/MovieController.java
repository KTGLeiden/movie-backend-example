package com.capgemini.movies.controllers;


import com.capgemini.movies.exceptions.BadRequestException;
import com.capgemini.movies.models.Movie;
import com.capgemini.movies.repositories.CategoryRepository;
import com.capgemini.movies.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/movies")
public class MovieController {
    @Autowired
    private MovieRepository movieRepository;

    @GetMapping
    public List<Movie> getMovies(){
        return this.movieRepository.findAll();
    }

    @GetMapping("/{id}")
    public Movie getMovie(@PathVariable Long id){
        return this.movieRepository.getOne(id);
    }

    @PostMapping
    public Movie createMovie(@RequestBody @Valid Movie movie) {
        if(movie.getId() != null) {
            throw new BadRequestException("A new entity cannot already have an ID!");
        }
        return movieRepository.save(movie);
    }

    @PutMapping
    public Movie updateMovie(@RequestBody @Valid Movie movie){
        if(movie.getId() == null) {
            throw new BadRequestException("A movie which you want to update needs to have an ID!");
        }
        return movieRepository.save(movie);
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Long id) {
        movieRepository.deleteById(id);
    }
}
