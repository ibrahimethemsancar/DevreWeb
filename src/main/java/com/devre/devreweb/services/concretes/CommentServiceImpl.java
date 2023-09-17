package com.devre.devreweb.services.concretes;

import com.devre.devreweb.entities.Comment;
import com.devre.devreweb.entities.Post;
import com.devre.devreweb.entities.User;
import com.devre.devreweb.repository.ICommentRepository;
import com.devre.devreweb.services.abstracts.ICommentService;
import com.devre.devreweb.services.abstracts.IPostService;
import com.devre.devreweb.services.abstracts.IUserService;
import com.devre.devreweb.services.requests.CreateCommentRequest;
import com.devre.devreweb.services.requests.UpdateCommentRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl  implements ICommentService {
    private ICommentRepository commentRepository;
    private IUserService userService;
    private IPostService postService;
    public CommentServiceImpl(ICommentRepository commentRepository, IUserService userService, IPostService postService) {
        this.commentRepository = commentRepository;
        this.userService = userService;
        this.postService = postService;
    }

    @Override
    public List<Comment> getAllComments(Optional<Long> userId, Optional<Long> postId) {
        if(userId.isPresent() && postId.isPresent()){
            return  commentRepository.findByUserIdAndPostId(userId.get(), postId.get());
        } else if (userId.isPresent()) {
            return commentRepository.findByUserId(userId.get());
        } else if (postId.isPresent()) {
            return commentRepository.findByPostId(postId.get());
        }else
            return commentRepository.findAll();
    }

    @Override
    public Comment getOneCommentById(Long commentId) {
        return commentRepository.findById(commentId).orElse(null);
    }

    @Override
    public Comment createOneComment(CreateCommentRequest request) {
        User user = userService.getOneUserById(request.userId);
        Post post = postService.getOnePostById(request.postId);

        if(user != null && post != null){
            Comment toSave = new Comment();
            toSave.setUser(user);
            toSave.setText(request.getText());
            toSave.setPost(post);
            toSave.setIsActv(1);
            return commentRepository.save(toSave);
        }else
            return null;
    }

    @Override
    public Comment updateOneCommentById(Long commentId, UpdateCommentRequest request) {
        Optional<Comment> comment = commentRepository.findById(commentId);
        if(comment.isPresent()){
            Comment commentToUpdate = comment.get();
            commentToUpdate.setText(commentToUpdate.getText().equals(request.getText()) ? commentToUpdate.getText() : request.getText());
            return commentRepository.save(commentToUpdate);
        }else
            return null;
    }

    @Override
    public void deleteOneCommentById(Long commentId) {
        if(commentId != null){
            Optional<Comment> comment = commentRepository.findById(commentId);
            if(comment.isPresent()){
                Comment deletedComment = comment.get();

                deletedComment.setIsActv(0);
            }
        }
    }
}
