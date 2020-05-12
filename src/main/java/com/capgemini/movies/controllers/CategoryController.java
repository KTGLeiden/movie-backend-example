package com.capgemini.movies.controllers;

import com.capgemini.movies.exceptions.BadRequestException;
import com.capgemini.movies.models.Category;
import com.capgemini.movies.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/categories")
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public List<Category> getCategorys(){
        return this.categoryRepository.findAll();
    }

    @GetMapping("/{id}")
    public Category getCategory(@PathVariable Long id){
        return this.categoryRepository.getOne(id);
    }

    @PostMapping
    public Category createCategory(@RequestBody @Valid Category category) {
        if(category.getId() != null) {
            throw new BadRequestException("A new entity cannot already have an ID!");
        }
        return categoryRepository.save(category);
    }

    @PutMapping
    public Category updateCategory(@RequestBody @Valid Category category){
        if(category.getId() == null) {
            throw new BadRequestException("A category which you want to update needs to have an ID!");
        }
        return categoryRepository.save(category);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryRepository.deleteById(id);
    }
}
