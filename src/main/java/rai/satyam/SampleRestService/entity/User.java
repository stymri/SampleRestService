package rai.satyam.SampleRestService.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class User {
	
	@NotNull
	@Size(min = 2 , max = 255 , message = "First name should be greater than 2 and less than 255 charater")
	private String fname ;
	
	@Size(max = 255)
	private String lname;
	
	@Id
	@Email(message = "Email must be well formed")
	@NotEmpty(message = "Email must not be empty")
	private String email;
	
	public User(String fname, String lname, String email) {
		this.fname = fname;
		this.lname = lname;
		this.email = email;
	}
	public User() {}
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
