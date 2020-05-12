package com.capgemini.movies.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Category model
 */
@Entity
public class Category {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Size(max = 200)
    @Column(unique=true)
    private String name;

    @Size(max = 1000)
    private String description;

    @OneToMany(mappedBy = "category", orphanRemoval = false)
    @JsonIgnore
    private List<Movie> movies;


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

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
