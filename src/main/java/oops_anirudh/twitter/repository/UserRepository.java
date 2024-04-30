package oops_anirudh.twitter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import oops_anirudh.twitter.model.User;


public interface UserRepository extends JpaRepository<User, Integer> {
    User findById(int id);
    User findByEmail(String email);
}

