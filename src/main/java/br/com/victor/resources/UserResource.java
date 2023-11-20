package br.com.victor.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.victor.domain.User;
import br.com.victor.dto.UserDTO;
import br.com.victor.services.UserService;

@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    private UserService userService;
    
    @GetMapping()
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> users = userService.findAll();

        List<UserDTO> usersDTO = users.stream().map(u -> new UserDTO(u)).toList();

        return ResponseEntity.ok().body(usersDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        User user = userService.findById(id);

        return ResponseEntity.ok().body(new UserDTO(user));
    }
}
