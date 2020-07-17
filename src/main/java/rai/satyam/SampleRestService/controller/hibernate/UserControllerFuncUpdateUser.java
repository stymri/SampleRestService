package rai.satyam.SampleRestService.controller.hibernate;

import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

import rai.satyam.SampleRestService.controller.DefaultResponse;
import rai.satyam.SampleRestService.entity.User;

public class UserControllerFuncUpdateUser extends UserControllerFuncBase<User> {
	private User g_objUser;
	private Errors g_objError;
	
	public void setError(Errors g_objError) {
		this.g_objError = g_objError;
	}

	public void setUser(User prm_objUser) {
		this.g_objUser = prm_objUser;
	}
	
	@Override
	public void startFunction() {
		// TODO Auto-generated method stub
		try {
			this.g_Response = new DefaultResponse<User>();
			this.g_Response.setStatus(0);
			this.g_Response.setMessage("Something went wrong");
			if(this.g_objError.hasErrors()) {
				String msg = "";
				for (ObjectError v_error : this.g_objError.getAllErrors()) {
					msg += " : ";
					msg += v_error.getDefaultMessage();
				}
				this.g_Response.setMessage(msg);
			}else if(isUserServiceInit()) {
				if (super.g_objUserService.updateUser(this.g_objUser)) {
					this.g_Response.setStatus(1);
					this.g_Response.setMessage("Success");
					this.g_Response.setData(this.g_objUser);
				}else {
					this.g_Response.setMessage("Something went wrong");
				}
			}
			
		} catch (Exception v_exException) {
			// TODO: handle exception
			v_exException.printStackTrace();
			this.g_Response.setMessage("Something went wrong");
		}
	}

}
