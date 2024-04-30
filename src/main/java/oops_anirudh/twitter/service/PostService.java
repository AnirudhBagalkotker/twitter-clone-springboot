package oops_anirudh.twitter.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oops_anirudh.twitter.dao.PostDAO;
import oops_anirudh.twitter.model.Post;
import oops_anirudh.twitter.model.User;
import oops_anirudh.twitter.repository.PostRepository;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final UserService userService;
    private final PostDAO postDAO;

    @Autowired
    public PostService(PostRepository postRepository, UserService userService, PostDAO postDAO) {
        this.postRepository = postRepository;
        this.userService = userService;
        this.postDAO = postDAO;
    }

    public String createPost(Object requestBody) {
        String postBody = postDAO.getPostBodyFromRequest(requestBody);
        int userId = postDAO.getUserIdFromRequest(requestBody);

        User user = userService.getUserDetails(userId);
        if (user != null) {
            Post post = new Post();
            post.setPostBody(postBody);
            post.setUser(user);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date currentDate = new Date();
            String formattedDate = dateFormat.format(currentDate);
            post.setDate(formattedDate);
            postRepository.save(post);
            return "Post created successfully";
        }
        return "User does not exist";
    }

    public String editPost(Object requestBody) {
        String postBody = postDAO.getPostBodyFromRequest(requestBody);
        int postId = postDAO.getPostIdFromRequest(requestBody);

        Post post = postRepository.findById(postId);
        if (post == null) {
            return "Post does not exist";
        }
        post.setPostBody(postBody);
        postRepository.save(post);
        return "Post edited successfully";
    }

    public Post getPost(int postId) {
        return postRepository.findById(postId);
    }

    public String deletePost(int postId) {
        postRepository.deleteById(postId);
        return null;
    }

    public List<Post> getAllPostsInReverseChronologicalOrder() {
        return postRepository.findAllByOrderByDateDesc();
    }
}
