package com.leonardocardozo.workshopmongo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leonardocardozo.workshopmongo.domain.Post;
import com.leonardocardozo.workshopmongo.repository.PostRepository;
import com.leonardocardozo.workshopmongo.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;


	public Post findById(String id) {
		Optional<Post> user = postRepository.findById(id);

		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Post> findByTitle(String text) {
		return postRepository.searchTitle(text);
	}
	
	public List<Post> fullSearch(String text, Date min, Date max) {
		max = new Date(max.getTime() + (24*60*60*1000));
		return postRepository.fullSearch(text, min, max);
	}
}
