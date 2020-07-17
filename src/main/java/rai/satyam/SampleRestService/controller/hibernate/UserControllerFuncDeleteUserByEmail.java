package rai.satyam.SampleRestService.controller.hibernate;

import org.hibernate.validator.internal.constraintvalidators.hv.EmailValidator;

import rai.satyam.SampleRestService.controller.DefaultResponse;

public class UserControllerFuncDeleteUserByEmail extends UserControllerFuncBase<Boolean> {
	
	private String g_strEmail;
	
	public void setEmail(String prm_strEmail) {
		this.g_strEmail = prm_strEmail;
	}
	
	@Override
	public void startFunction() {
		// TODO Auto-generated method stub
		try {
			this.g_Response = new DefaultResponse<Boolean>();
			this.g_Response.setStatus(0);
			this.g_Response.setData(false);
			//this.g_Response.setMessage("Something went wrong");
			if(isUserServiceInit() && isValidEmail()) {
				if(super.g_objUserService.deleteUserbyEmailId(g_strEmail)) {
					this.g_Response.setStatus(1);
					this.g_Response.setMessage("Success");
					this.g_Response.setData(true);
				}else {
					this.g_Response.setMessage("Not able to delete");
				}
			}
		}catch(Exception v_exException){
			this.g_Response.setMessage("Something went wrong");
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

}
