package com.realtime.blogapp.service;

import java.util.List;

import com.realtime.blogapp.dto.PostDto;

public interface PostService {
      List<PostDto> findallPosts();

      List<PostDto> findPostsByUser();

      void createPost(PostDto postDto);

      PostDto findPostById(Long postId);

      void updatePost(PostDto postDto);

      void deletePost(Long postId);

      PostDto findPostByUrl(String postUrl);

      List<PostDto> searchPosts(String query);
}
