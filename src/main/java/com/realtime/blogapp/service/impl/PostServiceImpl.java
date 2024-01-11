package com.realtime.blogapp.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.realtime.blogapp.dto.PostDto;
import com.realtime.blogapp.entity.Post;
import com.realtime.blogapp.mapper.PostMapper;
import com.realtime.blogapp.repository.PostRepository;
import com.realtime.blogapp.service.PostService;

@Service
public class PostServiceImpl implements PostService{

      private PostRepository postRepository;

      public PostServiceImpl(PostRepository postRepository)
      {
            this.postRepository = postRepository;
      }

      @Override
      public List<PostDto> findallPosts() {
            List<Post> posts =  postRepository.findAll();
            return posts.stream().map(PostMapper::mapToPostDto)
            .collect(Collectors.toList());
      }

      @Override
      public void createPost(PostDto postDto) {
            Post post = PostMapper.mapToPost(postDto);
            postRepository.save(post);
      }
      
}
