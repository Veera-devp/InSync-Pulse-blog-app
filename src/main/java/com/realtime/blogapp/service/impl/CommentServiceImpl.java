package com.realtime.blogapp.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.realtime.blogapp.dto.CommentDto;
import com.realtime.blogapp.entity.Comment;
import com.realtime.blogapp.entity.Post;
import com.realtime.blogapp.entity.User;
import com.realtime.blogapp.mapper.CommentMapper;
import com.realtime.blogapp.repository.CommentRepository;
import com.realtime.blogapp.repository.PostRepository;
import com.realtime.blogapp.repository.UserRepository;
import com.realtime.blogapp.service.CommentService;
import com.realtime.blogapp.util.SecurityUtils;

@Service
public class CommentServiceImpl implements CommentService {

      private CommentRepository commentRepository;
      private PostRepository postRepository;
      private UserRepository userRepository;

    public CommentServiceImpl(CommentRepository commentRepository,
                              PostRepository postRepository,
                              UserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

      @Override
      public void createComment(String postUrl, CommentDto commentDto) {

            Post post = postRepository.findByUrl(postUrl).get();
            Comment comment = CommentMapper.mapToComment(commentDto);
            comment.setPost(post);
            commentRepository.save(comment);
      }

      @Override
      public List<CommentDto> findAllComments() {
            List<Comment> comments = commentRepository.findAll();
            return comments.stream()
                        .map(CommentMapper::mapToCommentDto)
                        .collect(Collectors.toList());
      }

      @Override
      public void deleteComment(Long commentId) {
            commentRepository.deleteById(commentId);
      }
      @Override
    public List<CommentDto> findCommentsByPost() {
        String email = SecurityUtils.getCurrentUser().getUsername();
        User createdBy = userRepository.findByEmail(email);
        Long userId = createdBy.getId();
        List<Comment> comments = commentRepository.findCommentsByPost(userId);
        return comments.stream()
                .map((comment) -> CommentMapper.mapToCommentDto(comment))
                .collect(Collectors.toList());
    }
}
