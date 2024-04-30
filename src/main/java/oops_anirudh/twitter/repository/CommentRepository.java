package oops_anirudh.twitter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import oops_anirudh.twitter.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

    Comment findById(int commentId);
    void deleteById(int commentId);
}

