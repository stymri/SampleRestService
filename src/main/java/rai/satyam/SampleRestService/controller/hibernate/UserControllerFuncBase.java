package rai.satyam.SampleRestService.controller.hibernate;

import rai.satyam.SampleRestService.controller.DefaultResponse;
import rai.satyam.SampleRestService.service.UserService;

public abstract class UserControllerFuncBase<T> {
	protected UserService g_objUserService;
	protected DefaultResponse<T> g_Response;
	
	public void setUserService(UserService prm_objUserService) {
		this.g_objUserService = prm_objUserService;
	}
	
	public DefaultResponse<T> getResult() {
		return this.g_Response;
	}
	
	protected boolean isUserServiceInit() {
		boolean v_bReturn = false;
		try {
			if(null != this.g_objUserService) {
				v_bReturn = true;
			}else {
				this.g_Response.setMessage("User service not able to init");
			}
		}catch(Exception v_exException) {
			v_exException.printStackTrace();
		}
		return v_bReturn;
	}
	
	public abstract void startFunction();

}
