package com.devre.devreweb.services.abstracts;

import com.devre.devreweb.entities.Comment;
import com.devre.devreweb.services.requests.CreateCommentRequest;
import com.devre.devreweb.services.requests.UpdateCommentRequest;

import java.util.List;
import java.util.Optional;

public interface ICommentService {
    List<Comment> getAllComments(Optional<Long> userId, Optional<Long> postId);

    Comment getOneCommentById(Long commentId);

    Comment createOneComment(CreateCommentRequest request);

    Comment updateOneCommentById(Long commentId, UpdateCommentRequest request);

    void deleteOneCommentById(Long commentId);
}
