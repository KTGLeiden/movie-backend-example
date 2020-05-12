package com.capgemini.movies.dto;


import java.util.List;

public class CategoryDto {
    private Long id;
    private String name;
    private String description;
    private List<MovieListItemDto> movies;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<MovieListItemDto> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieListItemDto> movies) {
        this.movies = movies;
    }
}
