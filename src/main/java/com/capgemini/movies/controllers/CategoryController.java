package com.capgemini.movies.controllers;

import com.capgemini.movies.dto.CategoryDto;
import com.capgemini.movies.exceptions.BadRequestException;
import com.capgemini.movies.exceptions.NotFoundException;
import com.capgemini.movies.mappers.CategoryMapper;
import com.capgemini.movies.models.Category;
import com.capgemini.movies.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("api/categories")
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    @GetMapping
    public List<Category> getCategories(){
        return this.categoryRepository.findAll();
    }

    @GetMapping("/all")
    public List<CategoryDto> getCategoriesList(){
        return this.categoryRepository.findAll().stream().map(categoryMapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public CategoryDto getCategoryDetails(@PathVariable Long id){
        Category category = this.categoryRepository.findById(id).orElseThrow(() -> new NotFoundException("Category not found!"));
        return categoryMapper.toDto(category);
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
