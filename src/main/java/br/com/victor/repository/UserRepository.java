package br.com.victor.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.victor.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
    
}
