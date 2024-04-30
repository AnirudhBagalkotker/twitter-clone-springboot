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

import oops_anirudh.twitter.model.Comment;
import oops_anirudh.twitter.service.CommentService;

@RestController
@RequestMapping("/comment")
public class CommentController {
    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/")
    public ResponseEntity<String> createComment(@RequestBody Object requestBody) {
        String response = commentService.createComment(requestBody);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/")
    public ResponseEntity<?> getComment(@RequestParam("commentID") int commentId) {
        Comment comment = commentService.getComment(commentId);
        if (comment == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(comment);
    }

    @PatchMapping("/")
    public ResponseEntity<String> updateComment(@RequestBody Object requestBody) {
        String response = commentService.updateComment(requestBody);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/")
    public ResponseEntity<String> deleteComment(@RequestParam("commentID") int commentId) {
        String response = commentService.deleteComment(commentId);
        return ResponseEntity.ok(response);
    }
}