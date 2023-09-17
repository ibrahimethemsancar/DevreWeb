package com.devre.devreweb.controllers;

import com.devre.devreweb.entities.Post;
import com.devre.devreweb.services.abstracts.IPostService;
import com.devre.devreweb.services.requests.CreatePostRequest;
import com.devre.devreweb.services.requests.UpdatePostRequest;
import com.devre.devreweb.services.responses.PostListResponse;
import com.devre.devreweb.services.responses.PostResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
@CrossOrigin(origins = "http://localhost:3001")
public class PostController {
    private IPostService postService;
    public PostController(IPostService postService) {
        this.postService = postService;
    }

    @GetMapping(value = "/allPosts")
    public ResponseEntity<List<PostListResponse>> getAllPosts(@RequestParam(required = false) Optional<Long> userId, @RequestParam(required = false) Optional<Integer> categoryId){
        try{
            return new ResponseEntity(postService.getAllPost(userId, categoryId), HttpStatus.ACCEPTED);
        }catch (Exception e){
            System.out.println(e.getCause() + "---" +  e.getClass());
        }

        return null;
    }

    @PostMapping
    public ResponseEntity createOnePost(@RequestBody CreatePostRequest request){
         postService.createOnePost(request);
         return  new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/{postId}")
    public Post updateOnePost(@PathVariable Long postId , UpdatePostRequest request){
        return postService.updateOnePostById(postId, request);
    }

    @PutMapping("/delete/{postId}")
    public void  deleteOnePost(@PathVariable Long postId){
        postService.deleteOnePostById(postId);
    }
    @GetMapping("/category/{categoryId}")
    public List<PostResponse> getAllpostsByCategory(@PathVariable Integer categoryId){
        return postService.getAllPostsByCategory(categoryId);
    }
}
