package com.workShopMongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.workShopMongo.domain.Post;
import com.workShopMongo.domain.User;
import com.workShopMongo.dto.AuthorDTO;
import com.workShopMongo.dto.CommentDTO;
import com.workShopMongo.repository.PostRepository;
import com.workShopMongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.format(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post = new Post(null, sdf.parse("21/03/2018"), "Partiu Viegem", "Vou Viajar para São Paulo. Abraços!", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom Dia", "Acordei Feliz Hoje", new AuthorDTO(maria));
		
		CommentDTO comment = new CommentDTO("Boa Viajem Mano!", sdf.parse("21/03/2018"), new AuthorDTO(alex));
		CommentDTO comment2 = new CommentDTO("Aproveite", sdf.parse("22/03/2018"), new AuthorDTO(bob));
		CommentDTO comment3 = new CommentDTO("Tenha um Ótimo Dia!", sdf.parse("23/03/2018"), new AuthorDTO(alex));
		
		post.getComments().addAll(Arrays.asList(comment, comment2));
		post2.getComments().addAll(Arrays.asList(comment3));
		
		postRepository.saveAll(Arrays.asList(post, post2));
		
		maria.getPosts().addAll(Arrays.asList(post, post2));
		userRepository.save(maria);	
	}
}