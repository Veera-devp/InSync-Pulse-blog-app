package com.realtime.blogapp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.realtime.blogapp.dto.PostDto;
import com.realtime.blogapp.service.PostService;

@Controller
public class PostController {

      private PostService postService;

      public PostController(PostService postService) {
            this.postService = postService;
      }

      @GetMapping("/admin/posts")
      public String posts(Model model)
      {
            List<PostDto> posts = postService.findallPosts();
            model.addAttribute("posts", posts);
            return "/admin/posts";
      }
      @GetMapping("admin/posts/newpost")
      public String newPostForm(Model model)
      {
            PostDto postDto = new PostDto();
            model.addAttribute("post", postDto);
            return "admin/create_post";
      }

}
