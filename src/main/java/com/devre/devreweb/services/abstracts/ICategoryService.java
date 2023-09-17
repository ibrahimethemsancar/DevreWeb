package com.devre.devreweb.services.abstracts;

import com.devre.devreweb.entities.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService  {
    Category findCategoryById(int categoryId);
    List<Category> getAllCategories(Optional<Integer> categoryId);
}
