package com.posts.Services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.posts.Repositories.*;
import com.posts.Models.*;

@Service
public class PostService {

    @Autowired
	private PostRepository postRepo;
	
	public List<Post> getAllPosts() {
		return this.postRepo.findAll();
	}
	
	public Post addPost(Post post) {
		return this.postRepo.save(post);
	}
	
	public Post findbyId(Long id) {
		return this.postRepo.findById(id).orElseThrow();
	}

	public Post updatePost(Long id, @Valid Post modifiedPost) {
		final Post post = this.findbyId(id);
		post.setTitle(modifiedPost.getTitle());
		post.setContent(modifiedPost.getContent());
		post.setTags(modifiedPost.getTags());
		return this.postRepo.save(post);
	}
    
}
