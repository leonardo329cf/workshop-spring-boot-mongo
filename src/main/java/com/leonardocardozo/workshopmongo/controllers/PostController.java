package com.leonardocardozo.workshopmongo.controllers;



import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.leonardocardozo.workshopmongo.controllers.util.URL;
import com.leonardocardozo.workshopmongo.domain.Post;
import com.leonardocardozo.workshopmongo.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostController {
	
	@Autowired
	private PostService postService;

	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post obj =postService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Post>> findByTitle(
			@RequestParam(value = "title", required = false, defaultValue = "") final String title
			) {
		List<Post> list = postService.findByTitle(title);
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value = "/fullsearch", method = RequestMethod.GET)
	public ResponseEntity<List<Post>> findByTitle(
			@RequestParam(value = "text", required = false, defaultValue = "") final String text,
			@RequestParam(value = "minDate", required = false, defaultValue = "") final String minDate,
			@RequestParam(value = "maxDate", required = false, defaultValue = "") final String maxDate
			) {
		Date min = URL.convertDate(minDate, new Date(0L));
		Date max = URL.convertDate(maxDate, new Date());
		List<Post> list = postService.fullSearch(text, min, max);
		return ResponseEntity.ok().body(list);
	}
}
