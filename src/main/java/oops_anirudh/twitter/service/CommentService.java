package oops_anirudh.twitter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oops_anirudh.twitter.dao.CommentDAO;
import oops_anirudh.twitter.model.Comment;
import oops_anirudh.twitter.model.Post;
import oops_anirudh.twitter.model.User;
import oops_anirudh.twitter.repository.CommentRepository;
import oops_anirudh.twitter.repository.PostRepository;
import oops_anirudh.twitter.repository.UserRepository;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final CommentDAO commentDAO;


    @Autowired
    public CommentService(CommentRepository commentRepository, PostRepository postRepository, UserRepository userRepository, CommentDAO commentDAO) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.commentDAO = commentDAO;
    }

    public String createComment(Object requestBody) {
        String commentBody = commentDAO.getCommentBodyFromRequest(requestBody);
        int userId = commentDAO.getUserIdFromRequest(requestBody);
        int postId = commentDAO.getPostIdFromRequest(requestBody);

        User user = userRepository.findById(userId);
        Post post = postRepository.findById(postId);

        if (user == null) {
            return "User does not exist";
        }
        if(post == null){
            return "Post does not exist";
        }

        Comment comment = new Comment(commentBody, user, post);
        commentRepository.save(comment);
        return "Comment created successfully";
    }

    public Comment getComment(int commentId) {
        return commentRepository.findById(commentId);
    }

    public String updateComment(Object requestBody) {
        String commentBody = commentDAO.getCommentBodyFromRequest(requestBody);
        int commentId = commentDAO.getCommentIdFromRequest(requestBody);

        Comment comment = commentRepository.findById(commentId);
        if (comment == null) {
            return "Comment does not exist";
        }

        comment.setCommentBody(commentBody);
        commentRepository.save(comment);
        return "Comment updated successfully";
    }

    public String deleteComment(int commentId) {
        if (!commentRepository.existsById(commentId)) {
            return "Comment does not exist";
        }

        commentRepository.deleteById(commentId);
        return "Comment deleted successfully";
    }
}