package com.realtime.blogapp.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.realtime.blogapp.dto.PostDto;
import com.realtime.blogapp.entity.Post;
import com.realtime.blogapp.entity.User;
import com.realtime.blogapp.mapper.PostMapper;
import com.realtime.blogapp.repository.PostRepository;
import com.realtime.blogapp.repository.UserRepository;
import com.realtime.blogapp.service.PostService;
import com.realtime.blogapp.util.SecurityUtils;

@Service
public class PostServiceImpl implements PostService {

      private PostRepository postRepository;
      private UserRepository userRepository;

      public PostServiceImpl(PostRepository postRepository,
      UserRepository userRepository) {
            this.postRepository = postRepository;
            this.userRepository = userRepository;
      }

      @Override
    public List<PostDto> findPostsByUser() {
        String email = SecurityUtils.getCurrentUser().getUsername();
        User createdBy = userRepository.findByEmail(email);
        Long userId = createdBy.getId();
        List<Post> posts = postRepository.findPostsByUser(userId);
        return posts.stream()
                .map((post) -> PostMapper.mapToPostDto(post))
                .collect(Collectors.toList());
    }

      @Override
      public List<PostDto> findallPosts() {
            List<Post> posts = postRepository.findAll();
            return posts.stream().map(PostMapper::mapToPostDto)
                        .collect(Collectors.toList());
      }

      @Override
      public void createPost(PostDto postDto) {
            Post post = PostMapper.mapToPost(postDto);
            postRepository.save(post);
      }

      @Override
      public PostDto findPostById(Long postId) {
            Post post = postRepository.findById(postId).get();
            return PostMapper.mapToPostDto(post);
      }

      @Override
      public void updatePost(PostDto postDto) {
            Post post = PostMapper.mapToPost(postDto);
            postRepository.save(post);
      }

      @Override
      public void deletePost(Long postId) {
            postRepository.deleteById(postId);
      }

      @Override
      public PostDto findPostByUrl(String postUrl) {
            Post post = postRepository.findByUrl(postUrl).get();
            return PostMapper.mapToPostDto(post);
      }

      @Override
      public List<PostDto> searchPosts(String query) {
            List<Post> posts = postRepository.searchPosts(query);
            return posts.stream()
                        .map(PostMapper::mapToPostDto)
                        .collect(Collectors.toList());
      }
}
