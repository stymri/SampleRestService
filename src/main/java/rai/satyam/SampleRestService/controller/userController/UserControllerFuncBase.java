package rai.satyam.SampleRestService.controller.userController;

import rai.satyam.SampleRestService.repositories.UserRepository;

public abstract class UserControllerFuncBase {
	protected UserRepository g_objUserRepository;

	public void setUserRepository(UserRepository prm_objUserRepository) {
		this.g_objUserRepository = prm_objUserRepository;
	}
	
	protected boolean isValidRepo() {
		boolean v_bReturn = false;
		try {
			if(null != this.g_objUserRepository) {
				v_bReturn = true;
			}
		}catch(Exception v_exException) {
			v_exException.printStackTrace();
		}
		return v_bReturn;
	}
}
