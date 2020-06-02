package rai.satyam.SampleRestService.controller;

import java.net.URI;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import rai.satyam.SampleRestService.entity.Login;
import rai.satyam.SampleRestService.repositories.LoginRepository;

@RestController
public class LoginController {
	
	private LoginRepository loginRepository;
	
	public LoginController(LoginRepository loginRepository) {
		this.loginRepository = loginRepository;
	}



	@PostMapping(path = "/addLogin")
	public ResponseEntity<?> addLogin(@Valid @RequestBody Login login) {
		Login login1 = loginRepository.save(login);
		URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/"+login1.getUserName()).build().toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PostMapping(path = "/Login")
	public ResponseEntity<?> checkLogin(@Valid @RequestBody Login login) {
		if (loginRepository.existsById(login.getUserName())) {
			Login loginDetail = loginRepository.findById(login.getUserName()).get();
			System.out.println(loginDetail.getPassword());
			System.out.println(login.getPassword());
			if(loginDetail.getPassword().equals(login.getPassword())) {
				System.out.println("Correct path");
				return ResponseEntity.noContent().build();
			}else {
				return ResponseEntity.status(401).body("{\"status\":401,\"error\":\"Unauthorized\",\"message\":\"Unauthorized\"}");
			}
 		}else {
			throw new NoSuchElementException("User does not exists");
		}	
	}
	

}
