package com.realtime.blogapp.service;

import java.util.List;

import com.realtime.blogapp.dto.CommentDto;

public interface CommentService {
      void createComment(String postUrl, CommentDto commentDto);

      List<CommentDto> findAllComments();

      void deleteComment(Long commentId);

      List<CommentDto> findCommentsByPost();
}
