package rai.satyam.SampleRestService.controller.hibernate;

import java.util.List;

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
import rai.satyam.SampleRestService.service.UserService;

@RestController
@RequestMapping(path = "/hib")
public class UserControllerHibernate {
	
	private UserService g_objUserService;
	
	public UserControllerHibernate(UserService g_objUserService) {
		this.g_objUserService = g_objUserService;
	}

	@GetMapping(path = "/getAllUser")
	public DefaultResponse<List<User>> getAllUser(){
		UserControllerFuncGetAllUser v_fn;
		System.out.println("hello");
		v_fn = new UserControllerFuncGetAllUser();
		v_fn.setUserService(this.g_objUserService);
		v_fn.startFunction();
		
		return v_fn.getResult();
		
	}
	
	@GetMapping(path = "/getUserByEmailId/{prm_sEmail}")
	public DefaultResponse<User> getUserByEmailId(@PathVariable String prm_sEmail) {
		//System.out.println(email);
		UserControllerFuncGetUserByEmailId v_fn;
		v_fn = new UserControllerFuncGetUserByEmailId();
		v_fn.setEmail(prm_sEmail);
		v_fn.setUserService(this.g_objUserService);
		v_fn.startFunction();
		
		return v_fn.getResult();
	}
	
	@PostMapping(path = "/addUser")
	public DefaultResponse<User> addUser(@Valid @RequestBody User prm_objUser , Errors prm_objError) {
		UserControllerFuncAddUser v_fn;
		v_fn = new UserControllerFuncAddUser();
		v_fn.setUser(prm_objUser);
		v_fn.setUserService(this.g_objUserService);
		v_fn.setError(prm_objError);
		v_fn.startFunction();
		
		return v_fn.getResult();
	}
	
	@DeleteMapping(path = "/deleteUserByEmail/{prm_sEmail}")
	public DefaultResponse<Boolean> deleteUserByEmail(@PathVariable String prm_sEmail){
		UserControllerFuncDeleteUserByEmail v_fn;
		v_fn = new UserControllerFuncDeleteUserByEmail();
		v_fn.setEmail(prm_sEmail);
		v_fn.setUserService(this.g_objUserService);
		v_fn.startFunction();
		
		return v_fn.getResult();
		
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
		v_fn.setUserService(this.g_objUserService);
		v_fn.setError(prm_objError);
		v_fn.startFunction();
		
		return v_fn.getResult();
	}

}