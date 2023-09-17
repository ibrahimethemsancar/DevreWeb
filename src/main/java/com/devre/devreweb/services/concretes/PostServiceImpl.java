package com.devre.devreweb.services.concretes;

import com.devre.devreweb.entities.Category;
import com.devre.devreweb.entities.Post;
import com.devre.devreweb.entities.PostImage;
import com.devre.devreweb.entities.User;
import com.devre.devreweb.repository.IPostRepository;
import com.devre.devreweb.services.abstracts.ICategoryService;
import com.devre.devreweb.services.abstracts.IPostService;
import com.devre.devreweb.services.abstracts.IUserService;
import com.devre.devreweb.services.requests.CreatePostRequest;
import com.devre.devreweb.services.requests.UpdatePostRequest;
import com.devre.devreweb.services.responses.CommentResponse;
import com.devre.devreweb.services.responses.PostListResponse;
import com.devre.devreweb.services.responses.PostResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PostServiceImpl implements IPostService {
    private IPostRepository postRepository;
    private ICategoryService categoryService;

    private IUserService userService;

    @Autowired
    private ModelMapper modelMapper;

    public PostServiceImpl(IPostRepository postRepository, ICategoryService categoryService, IUserService userService) {
        this.postRepository = postRepository;
        this.categoryService = categoryService;
        this.userService = userService;
    }

    @Override
    public List<PostListResponse> getAllPost(Optional<Long> userId, Optional<Integer> categoryId) {
        if(userId.isPresent()){

            List<Post> allPostsByUserId = this.postRepository.findAllPostsByUserId(userId.get());
            List<PostListResponse> response = new ArrayList<>();
            allPostsByUserId.stream().forEach(post -> {
                PostListResponse postListResponse = new PostListResponse();
                postListResponse.setPostId(post.getId());

                if(post.getPostImageList().size() != 0 ){
                    List<PostImage> postImageList = new ArrayList<>(post.getPostImageList());
                    postListResponse.setPostImage(postImageList.get(0));
                }else {
                    postListResponse.setPostImage(null);
                }

                postListResponse.setTitle(post.getTitle());
                postListResponse.setDate(post.getUpdateDate());
                postListResponse.setWriterName(post.getUser().getFirstName() + post.getUser().getLastName());

                response.add(postListResponse);
            });
            return response;
        }
        else if(categoryId.isPresent()){
            List<Post> allPostsByUserId = this.postRepository.findByCategoryId(categoryId.get());
            List<PostListResponse> response = new ArrayList<>();
            allPostsByUserId.stream().forEach(post -> {
                PostListResponse postListResponse = new PostListResponse();
                postListResponse.setPostId(post.getId());

                List<PostImage> postImageList = new ArrayList<>(post.getPostImageList());
                postListResponse.setPostImage(postImageList.get(0));

                postListResponse.setTitle(post.getTitle());
                postListResponse.setDate(post.getUpdateDate());
                postListResponse.setWriterName(post.getUser().getFirstName() + " " + post.getUser().getLastName());

                response.add(postListResponse);
            });
            return response;
        }
        else {
            List<Post> postList = postRepository.findAll();
            if (!postList.isEmpty()) {
                List<Post> allPostsByUserId = this.postRepository.findByCategoryId(categoryId.get());
                List<PostListResponse> response = new ArrayList<>();
                allPostsByUserId.stream().forEach(post -> {
                    PostListResponse postListResponse = new PostListResponse();
                    postListResponse.setPostId(post.getId());

                    List<PostImage> postImageList = new ArrayList<>(post.getPostImageList());
                    postListResponse.setPostImage(postImageList.get(0));

                    postListResponse.setTitle(post.getTitle());
                    postListResponse.setDate(post.getUpdateDate());
                    postListResponse.setWriterName(post.getUser().getFirstName() + post.getUser().getLastName());

                    response.add(postListResponse);
                });
                return response;
            }
        }

        return null;
    }

    @Override
    public Post getOnePostById(Long postId) {
        if (postId != null) {
            this.postRepository.findById(postId);
        }
        return null;
    }

    @Override
    public List<Post> getAllPostByUserId(Long userId) {
        return postRepository.findAllPostsByUserId(userId);
    }

    @Override
    public void createOnePost(CreatePostRequest request) {
        int categoryId = request.getCategoryId();
        Long userId = request.getUserId();

        Category category = categoryService.findCategoryById(categoryId);
        User user = userService.getOneUserById(userId);

        if (category != null && user != null) {
            Post newPost = new Post();
            newPost.setTitle(request.getTitle());
            newPost.setContent(request.getContent());
            newPost.setPostKeywordList(request.getPostKeywordList());
            newPost.setPostImageList(request.getPostImageHashSet());
            newPost.setMetaTitle(request.metaTitle);
            newPost.setCategory(category);
            newPost.setUser(user);

            postRepository.save(newPost);
        }

    }

    @Override
    public Post updateOnePostById(Long postId, UpdatePostRequest request) {
        Optional<Post> post = postRepository.findById(postId);
        if (post.isPresent()) {
            Post toUpdate = post.get();
            Category updateCategory = categoryService.findCategoryById(request.getCategoryId());
            User updateUser = userService.getOneUserById(request.getUserId());

            toUpdate.setTitle(toUpdate.getTitle().equals(request.getTitle()) ? toUpdate.getTitle() : request.getTitle());
            toUpdate.setPostKeywordList(toUpdate.getPostKeywordList().equals(request.getPostKeywordList()) ? toUpdate.getPostKeywordList() : request.getPostKeywordList());
            toUpdate.setIsActv(toUpdate.getIsActv() == request.getIsActv() ? toUpdate.getIsActv() : request.getIsActv());
            toUpdate.setContent(toUpdate.getContent().equals(request.getContent()) ? toUpdate.getContent() : request.getContent());
            toUpdate.setPostImageList(toUpdate.getPostImageList().equals(request.getPostImageHashSet()) ? toUpdate.getPostImageList() : request.getPostImageHashSet());
            toUpdate.setMetaTitle(toUpdate.getMetaTitle().equals(request.getMetaTitle()) ? toUpdate.getMetaTitle() : request.getMetaTitle());
            if (updateCategory != null) {
                toUpdate.setCategory(toUpdate.getCategory().equals(updateCategory) ? toUpdate.getCategory() : updateCategory);
            }

            if (updateUser != null) {
                toUpdate.setUser(toUpdate.getUser().equals(updateUser) ? toUpdate.getUser() : updateUser);
            }
            postRepository.save(toUpdate);

            return toUpdate;
        }
        return null;
    }

    @Override
    public void deleteOnePostById(Long postId) {
        Post post = postRepository.findById(postId).orElse(null);
        if (post != null) {
            post.setIsActv(0);
            postRepository.save(post);
        }

    }

    @Override
    public List<PostResponse> getAllPostsByCategory(Integer categoryId) {
        List<Post> postList = postRepository.findByCategoryId(categoryId);
        if (!postList.isEmpty() && postList.size() != 0) {
            List<PostResponse> listPostResponse = new ArrayList<>();
            postList.stream().forEach(item -> {
                PostResponse postResponse = new PostResponse();

                postResponse.setCategoryId(item.getCategory().getId());
                postResponse.setCategoryName(item.getCategory().getName());
                postResponse.setTitle(item.getTitle());
                postResponse.setPostImageHashSet(item.getPostImageList());
                postResponse.setFirstName(item.getUser().getFirstName());
                postResponse.setLastName(item.getUser().getLastName());
                postResponse.setMetaTitle(item.getMetaTitle());

                listPostResponse.add(postResponse);


            });
            return listPostResponse;
        }
        return null;
    }
}
