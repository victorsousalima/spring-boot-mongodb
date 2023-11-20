package br.com.victor.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.victor.domain.User;
import br.com.victor.repository.UserRepository;
import br.com.victor.services.exception.ObjectNotFoundException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        Optional<User> user = userRepository.findById(id);
        
        return user.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }
    
}
