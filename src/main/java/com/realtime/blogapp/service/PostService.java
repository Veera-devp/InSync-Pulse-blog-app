package com.realtime.blogapp.service;

import java.util.List;

import com.realtime.blogapp.dto.PostDto;

public interface PostService {
      List<PostDto> findallPosts();

      void createPost(PostDto postDto);
}
