package rai.satyam.SampleRestService.controller.hibernate;

import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

import rai.satyam.SampleRestService.controller.DefaultResponse;
import rai.satyam.SampleRestService.entity.User;

public class UserControllerFuncAddUser extends UserControllerFuncBase<User> {
	private User g_objUser;
	private Errors g_objError;
	
	public void setError(Errors g_objError) {
		this.g_objError = g_objError;
	}

	public void setUser(User prm_objUser) {
		// TODO Auto-generated method stub
		this.g_objUser = prm_objUser;
	}
	
	@Override
	public void startFunction() {
		try {
			super.g_Response = new DefaultResponse<User>();
			super.g_Response.setStatus(0);
			if(this.g_objError != null &&  this.g_objError.hasErrors()) {
				String msg = "";
				for (ObjectError v_error : this.g_objError.getAllErrors()) {
					msg += " : ";
					msg += v_error.getDefaultMessage();
				}
				super.g_Response.setMessage(msg);
			}else if(isUserServiceInit()) {
				if(super.g_objUserService.addUser(this.g_objUser)) {
					super.g_Response.setStatus(1);
					super.g_Response.setMessage("Success");
					super.g_Response.setData(this.g_objUser);
				}else {
					super.g_Response.setMessage("Something went wrong");
				}
			}
			
		} catch (Exception v_exException) {
			// TODO: handle exception
			v_exException.printStackTrace();
			super.g_Response.setMessage("Something went wrong");
		}	
	}
	
}