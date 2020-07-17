package rai.satyam.SampleRestService.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import rai.satyam.SampleRestService.entity.Login;
import rai.satyam.SampleRestService.entity.LoginForm;
import rai.satyam.SampleRestService.entity.LoginResponse;
import rai.satyam.SampleRestService.repositories.LoginRepository;

@RestController
public class AuthenticationController {
	
	//public int g_iValue;
	private LoginRepository g_objLoginRepository;
	
	public AuthenticationController(LoginRepository g_objLoginRepository) {
		this.g_objLoginRepository = g_objLoginRepository;
	}



	@PostMapping(path = "/Auth")
	public LoginResponse login(@RequestBody  LoginForm prm_objLogin) {
		// obj , i for int , l for list , m for map , d for decimal or double , b for boolean , arr for array
		// prm_dataType for parameter variable
		// v for local variable
		
		AuthenticationControllerFuncLogin v_fn;
		
		v_fn = new AuthenticationControllerFuncLogin();
		
		v_fn.setLogin(prm_objLogin);
		
		v_fn.setG_objLoginRepository(g_objLoginRepository);
		
		v_fn.startFunction();
		
		return v_fn.getResult();
		//
	}

}
