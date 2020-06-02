package rai.satyam.SampleRestService.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Login {
	
	@Id
	@NotEmpty
	private String userName;
	
	@NotEmpty
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Login(@NotEmpty String userName, @NotEmpty String password) {
		this.userName = userName;
		this.password = password;
	}

	public Login() {}	
	
}
