package rai.satyam.SampleRestService.controller.userController;

import javax.validation.Valid;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rai.satyam.SampleRestService.controller.DefaultResponse;
import rai.satyam.SampleRestService.entity.User;
import rai.satyam.SampleRestService.repositories.UserRepository;

@RestController
@RequestMapping(path = "/new")
public class NewUserController {
	
	private UserRepository g_objUserRepository;
	
	public NewUserController(UserRepository g_objUserRepository) {
		this.g_objUserRepository = g_objUserRepository;
	}

	@GetMapping(path = "/getAllUser")
	public DefaultResponse<Iterable<User>> getAllUser(){
		UserControllerFuncGetAllUser v_fn;
		
		v_fn = new UserControllerFuncGetAllUser();
		v_fn.setUserRepository(this.g_objUserRepository);
		v_fn.startFunction();
		
		return v_fn.getResult();
		
		//DefaultResponse<Iterable<User>> v_objResponse = new DefaultResponse<Iterable<User>>();
		//v_objResponse.setStatus(0);
		//v_objResponse.setMessage("Response message");
		//v_objResponse.setData(g_objUserRepository.findAll());
		
		//return v_objResponse;
	}
	
	@GetMapping(path = "/getUserByEmailId/{prm_sEmail}")
	public DefaultResponse<User> getUserByEmailId(@PathVariable String prm_sEmail) {
		//System.out.println(email);
		UserControllerFuncGetUserByEmailId v_fn;
		v_fn = new UserControllerFuncGetUserByEmailId();
		v_fn.setEmail(prm_sEmail);
		v_fn.setUserRepository(this.g_objUserRepository);
		v_fn.startFunction();
		
		return v_fn.getResponse();
	}
	
	@PostMapping(path = "/addUser")
	public DefaultResponse<User> addUser(@Valid @RequestBody User prm_objUser , Errors prm_objError) {
		UserControllerFuncAddUser v_fn;
		v_fn = new UserControllerFuncAddUser();
		v_fn.setUser(prm_objUser);
		v_fn.setUserRepository(this.g_objUserRepository);
		v_fn.setError(prm_objError);
		v_fn.startFunction();
		
		return v_fn.getResponse();
		/*
		 * User user1 = userRepository.save(user); URI location =
		 * ServletUriComponentsBuilder.fromCurrentRequestUri().path("/"+user1.getEmail()
		 * ).build().toUri(); return ResponseEntity.created(location).build();
		 */
	}
	
	/** 
	 * 
	 * @param prm_sEmail {@link String} User Email Id
	 * @return {@link DefaultResponse} return data true if delete
	 */
	@DeleteMapping(path = "/deleteUserByEmail/{prm_sEmail}")
	public DefaultResponse<Boolean> deleteUserByEmail(@PathVariable String prm_sEmail){
		UserControllerFuncDeleteUserByEmail v_fn;
		v_fn = new UserControllerFuncDeleteUserByEmail();
		v_fn.setEmail(prm_sEmail);
		v_fn.setUserRepository(this.g_objUserRepository);
		v_fn.startFunction();
		
		return v_fn.getResponse();
		
	}
	
	/**
	 * 
	 * @author Satyam Rai
	 * @param prm_objUser {@link User}
	 * @param prm_objError {@link Errors}
	 * @return
	 */
	@PutMapping(path = "/updateUser")
	public DefaultResponse<User> updateUser(@Valid @RequestBody User prm_objUser , Errors prm_objError) {
		UserControllerFuncUpdateUser v_fn;
		v_fn = new UserControllerFuncUpdateUser();
		v_fn.setUser(prm_objUser);
		v_fn.setUserRepository(this.g_objUserRepository);
		v_fn.setError(prm_objError);
		v_fn.startFunction();
		
		return v_fn.getResponse();
	}

}
