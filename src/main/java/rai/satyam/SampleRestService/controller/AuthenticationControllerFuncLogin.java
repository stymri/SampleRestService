package rai.satyam.SampleRestService.controller;

import java.util.Optional;

import rai.satyam.SampleRestService.entity.Login;
import rai.satyam.SampleRestService.entity.LoginForm;
import rai.satyam.SampleRestService.entity.LoginResponse;
import rai.satyam.SampleRestService.repositories.LoginRepository;

public class AuthenticationControllerFuncLogin {
	
	private LoginResponse g_objReturn;
	private LoginForm g_objLogin;
	private Login g_objLogindata;
	
	private LoginRepository g_objLoginRepository;
	// first get 
	public LoginResponse getResult() {
		// TODO Auto-generated method stub
		return this.g_objReturn;
	}
	
	
	public void setLogin(LoginForm prm_objLogin) {
		// TODO Auto-generated method stub
		this.g_objLogin = prm_objLogin;
	}
	
	public void setG_objLoginRepository(LoginRepository g_objLoginRepository) {
		this.g_objLoginRepository = g_objLoginRepository;
	}


	/*
	 * public void startFunction() { // TODO Auto-generated method stub //
	 * validation try { g_objReturn = new LoginResponse(); // is input valid
	 * if(g_objLoginRepository != null) { if(this.isValidInput()) {
	 * if(g_objLoginRepository.existsById(g_objLogin.getUserName()) ) { Login
	 * v_objLogin = g_objLoginRepository.findById(g_objLogin.getUserName()).get();
	 * if(g_objLogin.getPassword().equals(v_objLogin.getPassword())){
	 * g_objReturn.setStatus(1); g_objReturn.setLogin(v_objLogin); }else {
	 * g_objReturn.setStatus(0); g_objReturn.setMsg("Password wrong"); } }else {
	 * g_objReturn.setStatus(0); g_objReturn.setMsg("User not exists"); } }else {
	 * g_objReturn.setStatus(0); g_objReturn.setMsg("Invalid Input"); } }else {
	 * g_objReturn.setStatus(0); g_objReturn.setMsg("Init failed"); }
	 * }catch(NullPointerException e) { e.printStackTrace(); } }
	 */
	// break code for function - for specific task
	// less DB connection
	// Readiblity for code if else
	// multiple initlation of value
	// response setting
	
	
	public void startFunction() {
		try {
			this.g_objReturn = new LoginResponse();
			this.g_objReturn.setStatus(0);
			if(!this.isValidInput()) {
				
			}else if(!this.isUserExits()){
				
			}else if(!this.matchPassword()) {
				
			}else {
				this.g_objReturn.setStatus(1);
				this.g_objReturn.setLogin(g_objLogindata);
			}
		}catch(Exception v_exException) {
			v_exException.printStackTrace();
		}
	}
	
	private boolean isValidInput() {
		boolean v_Return = false ;
		try {
			if(null == this.g_objLogin) {
				this.g_objReturn.setMsg("User is null");
			}else if(null == this.g_objLogin.getUserName() || "" == this.g_objLogin.getUserName()){
				this.g_objReturn.setMsg("User is empty");
			}else if(null == this.g_objLogin.getPassword() || "" == this.g_objLogin.getPassword()) {
				this.g_objReturn.setMsg("Password is empty");
			}else {
				v_Return = true;
			}
			
		}catch(Exception e) {
			return v_Return;
		}
		return v_Return;
	}
	
	private boolean isUserExits() {
		boolean v_return = false;
		Optional<Login> v_objCheckuser;
		try {
			if(null == this.g_objLoginRepository) {
				this.g_objReturn.setMsg("Init failed");
			}else {
				v_objCheckuser= this.g_objLoginRepository.findById(this.g_objLogin.getUserName());
				if(! v_objCheckuser.isPresent()) {
					this.g_objReturn.setMsg("Invalid Username or password");
				}else {
					this.g_objLogindata = v_objCheckuser.get();
					v_return = true;
				}
			}
		}catch(Exception v_exException) {
			v_exException.printStackTrace();
		}
		return v_return;
	}
	
	private boolean matchPassword() {
		boolean v_return = false;
		try {
			if(this.g_objLogindata.getPassword().equals(this.g_objLogin.getPassword())) {
				v_return = true;
			}else {
				this.g_objReturn.setMsg("Invalid Username or password");
			}
		}catch(Exception v_exException) {
			v_exException.printStackTrace();
		}
		return v_return;
	}
	
}
