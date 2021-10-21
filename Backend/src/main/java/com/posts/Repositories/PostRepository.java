package com.posts.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.posts.Models.*;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
	
	Optional<Post> findByTitle(String title);

    List<Post> findByIdIn(List<Post> postIds);

    Optional<Post> findByTags(String tags);

    Boolean existsByTitle(String title);

    List<Post> getAllPosts();

    Post addPost(Post post);

    Optional<Post> findById(Long id);

    Post updatePost(Long id, Post modifiedPost);

    //Boolean existsByEmail(String email);

}