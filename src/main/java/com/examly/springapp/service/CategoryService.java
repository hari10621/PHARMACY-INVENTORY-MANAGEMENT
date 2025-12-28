package com.examly.springapp.service;

import com.examly.springapp.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService {

    Category addCategory(Category category);

    Page<Category> getAllCategories(Pageable pageable);

    Category getCategoryById(Long id);

    Category updateCategory(Long id, Category category);

    void deleteCategory(Long id);
}
