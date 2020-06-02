package rai.satyam.SampleRestService.controller;

import java.net.URI;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import rai.satyam.SampleRestService.entity.User;
import rai.satyam.SampleRestService.repositories.UserRepository;

@RestController
public class UserController {
	
	private UserRepository userRepository;

	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@GetMapping(path = "/Users")
	public Iterable<User> getUsers(){
		return userRepository.findAll();
	}
	
	@PostMapping(path = "/User")
	public ResponseEntity<?> addUser(@Valid @RequestBody User user) {
		User user1 = userRepository.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/"+user1.getEmail()).build().toUri();
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping(path = "/User/{email}")
	public User getUser(@PathVariable String email) {
		Optional<User> user;
		user = userRepository.findById(email);
		return user.get();
	}
	
	@DeleteMapping(path = "/User/{email}")
	public ResponseEntity<?> deleteUser(@PathVariable String email){
		userRepository.deleteById(email);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(path = "/User")
	public ResponseEntity<?> updateUser(@Valid @RequestBody User user){
		if (userRepository.existsById(user.getEmail())) {
			userRepository.save(user);
			return ResponseEntity.noContent().build();
		}else {
			throw new NoSuchElementException("User does not exists");
		}
	}
}
