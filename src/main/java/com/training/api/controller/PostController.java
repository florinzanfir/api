package com.training.api.controller;

import com.training.api.payload.PostDto;
import com.training.api.payload.PostResponse;
import com.training.api.service.PostService;
import com.training.api.utils.AppConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/posts")
public class PostController {

    PostService postService;

    public PostController(PostService postService) {

        this.postService = postService;
    }

    // create post rest api
    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {

        return new ResponseEntity<>(this.postService.createPost(postDto), HttpStatus.CREATED);
    }


    // get all posts rest api
    @GetMapping
    public ResponseEntity<PostResponse> getAllPosts(
            @RequestParam(value = "pageNumber", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNumber,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDirection", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDirection

    ) {

        return ResponseEntity.ok(this.postService.getAllPosts(pageNumber, pageSize, sortBy, sortDirection));
    }


    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable long id) {

        return ResponseEntity.ok(this.postService.getPostById(id));
    }


    @PostMapping("/{id}")
    public ResponseEntity<PostDto> updatePostById(@RequestBody PostDto postDto, @PathVariable long id) {
        PostDto postResponse = postService.updatePostById(postDto, id);

        return new ResponseEntity<>(postResponse, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable long id) {

        postService.deletePostById(id);

       return new ResponseEntity<>("Post deleted succesfully", HttpStatus.OK);
    }
}
