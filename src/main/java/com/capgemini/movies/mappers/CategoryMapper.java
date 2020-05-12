package com.capgemini.movies.mappers;

import com.capgemini.movies.dto.CategoryDto;
import com.capgemini.movies.models.Category;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CategoryMapper {
    public CategoryDto toDto(Category category) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(category, CategoryDto.class);
    }
}
