package oops_anirudh.twitter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import oops_anirudh.twitter.model.Post;
import oops_anirudh.twitter.service.PostService;

@RestController
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/")
    public ResponseEntity<String> createPost(@RequestBody Object requestBody) {
        String response = postService.createPost(requestBody);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/")
    public ResponseEntity<String> editPost(@RequestBody Object requestBody) {
        String response = postService.editPost(requestBody);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/")
    public ResponseEntity<?> getPost(@RequestParam("postID") int postId) {
        Post post = postService.getPost(postId);
        if (post == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(post);
    }

    @DeleteMapping("/")
    public ResponseEntity<String> deletePost(@RequestParam("postID") int postId) {
        String response = postService.deletePost(postId);
        return ResponseEntity.ok(response);
    }
}
