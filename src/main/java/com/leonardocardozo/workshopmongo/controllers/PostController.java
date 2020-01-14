package com.leonardocardozo.workshopmongo.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.leonardocardozo.workshopmongo.domain.Post;
import com.leonardocardozo.workshopmongo.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostController {
	
	@Autowired
	private PostService userService;

	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post obj = userService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
