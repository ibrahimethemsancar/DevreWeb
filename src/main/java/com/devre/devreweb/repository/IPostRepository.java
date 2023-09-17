package com.devre.devreweb.repository;

import com.devre.devreweb.entities.Post;
import com.devre.devreweb.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPostRepository extends JpaRepository<Post,Long> {
    List<Post> findAllPostsByUserId(Long userId);

    List<Post> findByCategoryId(Integer categoryId);
}
