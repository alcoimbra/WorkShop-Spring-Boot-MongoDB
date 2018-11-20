package com.workShopMongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.workShopMongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}