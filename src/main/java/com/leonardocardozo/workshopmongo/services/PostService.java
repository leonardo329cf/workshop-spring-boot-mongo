package com.leonardocardozo.workshopmongo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leonardocardozo.workshopmongo.domain.Post;
import com.leonardocardozo.workshopmongo.repository.PostRepository;
import com.leonardocardozo.workshopmongo.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository userRepository;


	public Post findById(String id) {
		Optional<Post> user = userRepository.findById(id);

		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));

	}
}
