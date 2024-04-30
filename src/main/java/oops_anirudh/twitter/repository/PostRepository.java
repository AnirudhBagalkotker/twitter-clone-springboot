package oops_anirudh.twitter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import oops_anirudh.twitter.model.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {
    Post findById(int postId);
    void deleteById(int postId);
    List<Post> findAllByOrderByDateDesc();
}
