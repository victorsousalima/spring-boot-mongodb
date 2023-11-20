package br.com.victor.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.victor.domain.Post;

public interface PostRepository extends MongoRepository<Post, String>{
    
    List<Post> findByTitleContainingIgnoreCase(String text);
}
