package oops_anirudh.twitter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import oops_anirudh.twitter.model.Post;
import oops_anirudh.twitter.service.PostService;

@RestController
@RequestMapping("/")
public class UserFeedController {

    private final PostService postService;

    @Autowired
    public UserFeedController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Post>> getUserFeed() {
        List<Post> posts = postService.getAllPostsInReverseChronologicalOrder();
        return ResponseEntity.ok(posts);
    }
}
