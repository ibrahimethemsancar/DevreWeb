package com.devre.devreweb.repository;

import com.devre.devreweb.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICommentRepository extends JpaRepository<Comment,Long> {
    List<Comment> findByUserIdAndPostId(Long userId, Long postId);

    List<Comment> findByUserId(Long userId);

    List<Comment> findByPostId(Long postId);
}
