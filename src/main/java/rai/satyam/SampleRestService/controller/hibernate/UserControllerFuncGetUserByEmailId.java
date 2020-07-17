package rai.satyam.SampleRestService.controller.hibernate;

import org.hibernate.validator.internal.constraintvalidators.hv.EmailValidator;

import rai.satyam.SampleRestService.controller.DefaultResponse;
import rai.satyam.SampleRestService.entity.User;

public class UserControllerFuncGetUserByEmailId extends UserControllerFuncBase<User>{

	private String g_strEmail;
	private User g_objUser;

	public void setEmail(String prm_strEmail) {
		this.g_strEmail = prm_strEmail;
	}
	
	@Override
	public void startFunction() {
		try {
			this.g_Response = new DefaultResponse<User>();
			this.g_Response.setStatus(0);
			this.g_Response.setMessage("Something went wrong");
			if(isUserServiceInit() && isValidEmail() && isUserExists()) {
				this.g_Response.setStatus(1);
				this.g_Response.setMessage("Success");
				this.g_Response.setData(g_objUser);
			}
		}catch(Exception v_exException){
			v_exException.printStackTrace();
		}
	}
	
	private boolean isValidEmail() {
		boolean v_bReturn = false;
		try {
			if(null == this.g_strEmail) {
				this.g_Response.setMessage("Email must not be null");
			}else if(this.g_strEmail.trim().isEmpty()) {
				this.g_Response.setMessage("Email must not be empty");
			}else if(!new EmailValidator().isValid(this.g_strEmail, null)) {
				this.g_Response.setMessage("Email must well formed");
			}else {
				v_bReturn = true;
			}
		}catch(Exception v_exException) {
			v_exException.printStackTrace();
		}
		return v_bReturn;
	}
	
	private boolean isUserExists() {
		boolean v_bReturn = false;
		try {
			 this.g_objUser =  super.g_objUserService.getUserByEmail(g_strEmail);
			if(null == this.g_objUser) {
				this.g_Response.setMessage("User not Exists");
			}else {
				v_bReturn = true;
			}
		}catch(Exception v_exException) {
			v_exException.printStackTrace();
		}
		return v_bReturn;
	}

}
