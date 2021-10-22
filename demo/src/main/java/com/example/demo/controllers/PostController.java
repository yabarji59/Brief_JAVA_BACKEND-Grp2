package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {
    
    @RequestMapping("/")
public String hello() 
{
return "Hello java";
}

}
