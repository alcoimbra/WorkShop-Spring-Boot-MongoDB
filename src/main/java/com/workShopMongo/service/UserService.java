package com.workShopMongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workShopMongo.domain.User;
import com.workShopMongo.repository.UserRepository;
import com.workShopMongo.service.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findyById(String id) {
		if(id == null) {
			throw new ObjectNotFoundException("Objeto não Encontrado");
		}
		
		return this.repo.findById(id).orElse(null);
	}
}