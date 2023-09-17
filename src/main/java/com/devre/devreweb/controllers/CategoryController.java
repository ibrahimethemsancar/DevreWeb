package com.devre.devreweb.controllers;

import com.devre.devreweb.entities.Category;
import com.devre.devreweb.services.abstracts.ICategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private ICategoryService categoryService;

    public CategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getAllCategories(@RequestParam Optional<Integer> categoryId){
        return this.categoryService.getAllCategories(categoryId);
    }

}
