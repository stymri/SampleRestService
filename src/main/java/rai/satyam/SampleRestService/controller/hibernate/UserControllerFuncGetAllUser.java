package rai.satyam.SampleRestService.controller.hibernate;

import java.util.List;
import rai.satyam.SampleRestService.controller.DefaultResponse;
import rai.satyam.SampleRestService.entity.User;

public class UserControllerFuncGetAllUser extends UserControllerFuncBase<List<User>>{

	@Override
	public void startFunction() {
		// TODO Auto-generated method stub
		try {
			super.g_Response = new DefaultResponse<List<User>>();
			super.g_Response.setStatus(0);
			if(super.isUserServiceInit()) {
				super.g_Response.setData(super.g_objUserService.getAllUsers());
				super.g_Response.setStatus(1);
		        super.g_Response.setMessage("Success");
			}
		}catch(Exception v_exException){
			v_exException.printStackTrace();
			super.g_Response.setMessage("Something went wrong");
		}
	}
}
