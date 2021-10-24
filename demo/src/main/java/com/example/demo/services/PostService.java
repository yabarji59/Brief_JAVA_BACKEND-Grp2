package com.example.demo.services;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;

import com.example.demo.models.Post;
import com.example.demo.repositories.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class PostService {

    @Autowired
	private PostRepository postRepo;
	
	public List<Post> getAllPosts() {
		return this.postRepo.findAll();
	}
	
	public Post addPost(Post post) {
		return this.postRepo.save(post);
	}
	
	public Post findById(Long id) {
		Optional<Post> optionalPost = this.postRepo.findById(id);
		return optionalPost.get();
	}

	public Post updatePost(Long id, @Valid Post modifiedPost) {
		final Post post = this.findById(id);
		post.setTitle(modifiedPost.getTitle());
		post.setContent(modifiedPost.getContent());
		post.setTags(modifiedPost.getTags());
		return this.postRepo.save(post);
	}

	public void deletePost(Long postId) {
		final Post post = this.findById(postId);
	}
    
}
