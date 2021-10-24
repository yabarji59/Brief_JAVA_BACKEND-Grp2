package com.example.demo.services;
import java.util.List;
import java.util.Optional;


import com.example.demo.models.Post;
import com.example.demo.models.PostRequest;
import com.example.demo.repository.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Optional<Post> findById(String id) {
        return postRepository.findById(id);
    }

    public void changePublishedFlag(String id, PostRequest request) {
        Optional<Post> post = findById(id);
        if (post.isPresent()) {
            Post p = post.get();
            p.setPublished(request.isPublished());
            postRepository.save(p);
        }
    }

    public String save(PostRequest request) {
        Post post = new Post();
        post.setTitle(request.getTitle());
        post.setContent(request.getContent());
        post.setPublished(false);
        post.setTags(request.getTags());

        return postRepository.save(post)
                             .getId();
    }

    public void update(String id, PostRequest request) {
        Optional<Post> post = findById(id);
        if (post.isPresent()) {
            Post forUpdate = post.get();
            forUpdate.setContent(request.getContent());
            forUpdate.setTitle(request.getTitle());
            forUpdate.setTags(request.getTags());
            postRepository.save(forUpdate);
        }
    }

    public List<Post> getAll() {
        return postRepository.findAll();
    }

    public List<Post> findByTitle(String title) {
        return postRepository.findAllByTitleContaining(title);
    }

    public void delete(String id) {
        Optional<Post> post = findById(id);
        post.ifPresent(postRepository::delete);
    }
}