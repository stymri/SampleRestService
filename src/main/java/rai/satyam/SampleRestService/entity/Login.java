package rai.satyam.SampleRestService.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "login")
public class Login {
	
	@Id
	@NotEmpty
	private String userName;
	
	@NotEmpty
	private String password;
	
	
	private String gender;
	
	@Column(name = "date_of_birth")
	private String date_of_birth;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
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
