package com.devre.devreweb.repository;

import com.devre.devreweb.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {
    List<Category> findAllById(Integer categoryId);
}
