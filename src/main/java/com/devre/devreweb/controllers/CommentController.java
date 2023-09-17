package com.devre.devreweb.controllers;

import com.devre.devreweb.entities.Comment;
import com.devre.devreweb.services.abstracts.ICommentService;
import com.devre.devreweb.services.requests.CreateCommentRequest;
import com.devre.devreweb.services.requests.UpdateCommentRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comments")
public class CommentController {
    private ICommentService commentService;

    public CommentController(ICommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public List<Comment> getAllComments(@RequestParam Optional<Long> userId, @RequestParam Optional<Long> postId){
        return commentService.getAllComments(userId, postId);
    }

    @GetMapping("/{commentId}")
    public Comment getOneComment(@PathVariable Long commentId){
        return commentService.getOneCommentById(commentId);
    }
    @PostMapping
    public Comment creteOneComment(@RequestBody CreateCommentRequest request){
       return commentService.createOneComment(request);
    }

    @PutMapping("/{commentId}")
    public Comment updateOneComment(@PathVariable Long commentId, @RequestBody UpdateCommentRequest request){
        return commentService.updateOneCommentById(commentId, request);
    }

    @PutMapping("/delete/{commentId}")
    public void deleteOneComment(@PathVariable Long commentId){
        commentService.deleteOneCommentById(commentId);
    }
}
