package com.realtime.blogapp.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.realtime.blogapp.dto.CommentDto;
import com.realtime.blogapp.entity.Comment;
import com.realtime.blogapp.entity.Post;
import com.realtime.blogapp.mapper.CommentMapper;
import com.realtime.blogapp.repository.PostRepository;
import com.realtime.blogapp.repository.CommentRepository;
import com.realtime.blogapp.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

      private CommentRepository commentRepository;
      private PostRepository postRepository;

    public CommentServiceImpl(CommentRepository commentRepository,
                              PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
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
}
