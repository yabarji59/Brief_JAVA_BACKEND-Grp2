package com.example.demo.services;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;

import com.example.demo.models.Post;
import com.example.demo.repository.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		Optional<Post> optionalPost = this.postRepo.findById(id);
		return optionalPost.get();
	}

	public Post updatePost(Long id, @Valid Post modifiedPost) {
		final Post post = this.findbyId(id);
		post.setTitle(modifiedPost.getTitle());
		post.setContent(modifiedPost.getContent());
		post.setTags(modifiedPost.getTags());
		return this.postRepo.save(post);
	}

	public String save(Post post) {
    
        post.setTitle(post.getTitle());
        post.setContent(post.getContent());
        post.setPublished(false);
        post.setTags(post.getTags());

        return postRepo.save(post)
                             .getId();
    }

}
