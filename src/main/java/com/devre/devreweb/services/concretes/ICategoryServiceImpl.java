package com.devre.devreweb.services.concretes;

import com.devre.devreweb.entities.Category;
import com.devre.devreweb.repository.ICategoryRepository;
import com.devre.devreweb.services.abstracts.ICategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ICategoryServiceImpl implements ICategoryService {
    private ICategoryRepository categoryRepository;

    public ICategoryServiceImpl(ICategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category findCategoryById(int categoryId) {
        return categoryRepository.findById(categoryId).orElse(null);
    }

    @Override
    public List<Category> getAllCategories(Optional<Integer> categoryId) {
        if(categoryId.isPresent()){
           return categoryRepository.findById(categoryId.get()).stream().toList();
        }
        return categoryRepository.findAll() ;
    }
}
