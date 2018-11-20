package com.workShopMongo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.workShopMongo.domain.Post;
import com.workShopMongo.service.PostsService;

@RestController
@RequestMapping(value="/posts")
public class PostsResource {
	
	@Autowired
	private PostsService service;

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Post> findById(@PathVariable("id") String id){
		Post obj = service.findyById(id);
		
		return ResponseEntity.ok().body(obj);
	}
}