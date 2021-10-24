package com.example.demo.controllers;

import com.example.demo.repositories.PostRepository;
import com.example.demo.services.PostService;
import com.example.demo.models.Post;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
	private PostService postServ;
	
	@Autowired
	private PostRepository postRepo;
    
    @RequestMapping("/")
    public String hello() 
        {
        return "Hello java";
        }


        
        /**
         * @author: Alex <3
         * @param id: id du post qu'on veut afficher
         * @return le post avec l'id
         */
        @GetMapping("/posts/{id}")
        public Post finById(@PathVariable(value = "id") Long id) {
            return this.postServ.findById(id);
        } 

        /**
         * @author: Alex
         * @param post: le post à sauvegarder
         * @return ?
         */
        @PostMapping("/posts")
	    public Post addPost(@Valid @RequestBody Post post) {
		return this.postServ.addPost(post);
	    }
	


        /**
         * @author: Alex et Amira
         * @param id: id du post à supprimer
         */
        @DeleteMapping("/posts/{id}")
        public void deleteById(@PathVariable(value = "id") Long id){
            this.postServ.deleteById(id);
        }

}
