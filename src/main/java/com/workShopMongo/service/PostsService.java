package com.workShopMongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workShopMongo.domain.Post;
import com.workShopMongo.repository.PostRepository;
import com.workShopMongo.service.exception.ObjectNotFoundException;

@Service
public class PostsService {
	
	@Autowired
	private PostRepository repo;
	
	public Post findyById(String id) {
		if(id == null) {
			throw new ObjectNotFoundException("Objeto não Encontrado");
		}
		
		return this.repo.findById(id).orElse(null);
	}
	
	public List<Post> findyByTitle(String text){
		return repo.findByTitleContaining(text);
	}
}