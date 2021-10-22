package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.*;


@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
	
	Optional<Post> findByTitle(String title);

    Optional<Post> findByTags(String tags);

    Boolean existsByTitle(String title);

    List<Post> getAllPosts();

    Post addPost(Post post);

    Optional<Post> findById(Long id);

    Post updatePost(Long id, Post modifiedPost);

    //Boolean existsById(Long id);

}