package br.com.victor.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.victor.domain.Post;
import br.com.victor.repository.PostRepository;
import br.com.victor.services.exception.ObjectNotFoundException;

@Service
public class PostService {
    
    @Autowired
    private PostRepository postRepository;

    public Post findById(String id) {
        Optional<Post> post = postRepository.findById(id);

        return post.orElseThrow(() -> new ObjectNotFoundException("Post not found"));
    }
}
