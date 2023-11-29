package com.training.api.service;

import com.training.api.payload.PostDto;
import com.training.api.payload.PostResponse;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);

    PostResponse getAllPosts(int pageNumber, int pageSize, String sortBy, String sortDirection);

    PostDto getPostById(long id);


    PostDto updatePostById(PostDto postDto, long id);

    void deletePostById(long id);
}
