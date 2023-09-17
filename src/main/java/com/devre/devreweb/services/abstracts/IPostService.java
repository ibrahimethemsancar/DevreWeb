package com.devre.devreweb.services.abstracts;

import com.devre.devreweb.entities.Post;
import com.devre.devreweb.services.requests.CreatePostRequest;
import com.devre.devreweb.services.requests.UpdatePostRequest;
import com.devre.devreweb.services.responses.PostListResponse;
import com.devre.devreweb.services.responses.PostResponse;

import java.util.List;
import java.util.Optional;

public interface IPostService {
    List<PostListResponse> getAllPost(Optional<Long> userId, Optional<Integer> categoryId);

    Post getOnePostById(Long postId);

    List<Post> getAllPostByUserId(Long userId);

    void createOnePost(CreatePostRequest request);

    Post updateOnePostById(Long postId, UpdatePostRequest request);

    void deleteOnePostById(Long postId);

    List<PostResponse> getAllPostsByCategory(Integer categoryId);
}
