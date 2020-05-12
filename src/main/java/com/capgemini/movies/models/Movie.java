package com.capgemini.movies.models;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Movie model.
 */
@Entity
public class Movie {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Size(max = 200)
    @Column(unique=true)
    private String name;

    @Size(max = 1000)
    private String description;

    @NotNull
    @Size(max = 20, min = 5)
    private String youtubeId;

    @NotNull
    @Range(min = 1900, max = 2050)
    private Integer year;

    @ManyToOne
    @NotNull
    private Category category;

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

    public String getYoutubeId() {
        return youtubeId;
    }

    public void setYoutubeId(String youtubeId) {
        this.youtubeId = youtubeId;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
