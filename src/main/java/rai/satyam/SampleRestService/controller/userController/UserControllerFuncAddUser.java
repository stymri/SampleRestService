package rai.satyam.SampleRestService.controller.userController;

import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

import rai.satyam.SampleRestService.controller.DefaultResponse;
import rai.satyam.SampleRestService.entity.User;

public class UserControllerFuncAddUser extends UserControllerFuncBase {
	private User g_objUser;
	private DefaultResponse<User> g_Response;
	private Errors g_objError;
	
	public DefaultResponse<User> getResponse() {
		return this.g_Response;
	}
	
	public void setError(Errors g_objError) {
		this.g_objError = g_objError;
	}


	public void setUser(User prm_objUser) {
		// TODO Auto-generated method stub
		this.g_objUser = prm_objUser;
	}

	public void startFunction() {
		try {
			this.g_Response = new DefaultResponse<User>();
			this.g_Response.setStatus(0);
			this.g_Response.setMessage("Something went wrong");
			if(this.g_objError != null &&  this.g_objError.hasErrors()) {
				String msg = "";
				for (ObjectError v_error : this.g_objError.getAllErrors()) {
					msg += " : ";
					msg += v_error.getDefaultMessage();
				}
				this.g_Response.setMessage(msg);
			}else if(isValidRepo()) {
				this.g_objUser =  super.g_objUserRepository.save(this.g_objUser);
				this.g_Response.setStatus(1);
				this.g_Response.setMessage("Success");
				this.g_Response.setData(this.g_objUser);
			}
			
		} catch (Exception v_exException) {
			// TODO: handle exception
			v_exException.printStackTrace();
		}	
	}
}
