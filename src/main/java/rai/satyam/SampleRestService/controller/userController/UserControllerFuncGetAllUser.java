package rai.satyam.SampleRestService.controller.userController;

import rai.satyam.SampleRestService.controller.DefaultResponse;
import rai.satyam.SampleRestService.entity.User;

public class UserControllerFuncGetAllUser extends UserControllerFuncBase {

	private DefaultResponse<Iterable<User>> g_Response;

	public DefaultResponse<Iterable<User>> getResult() {
		return this.g_Response;
	}
	
	public void startFunction() {
		try {
			this.g_Response = new DefaultResponse<Iterable<User>>();
			this.g_Response.setStatus(0);
			this.g_Response.setMessage("Something went wrong");
			if(isValidRepo()) {
				this.g_Response.setStatus(1);
				this.g_Response.setMessage("Success");
				this.g_Response.setData(super.g_objUserRepository.findAll());
			}
		}catch(Exception v_exException){
			v_exException.printStackTrace();
		}
	}
}
