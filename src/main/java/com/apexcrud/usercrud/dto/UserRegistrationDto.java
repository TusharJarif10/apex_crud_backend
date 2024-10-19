package com.apexcrud.usercrud.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserRegistrationDto {
    
    @NotEmpty
    private String userid;
    
    @NotEmpty
    private String username;

    @NotEmpty
    @Size(min = 6, message = "minimum password length is 6 characters")
    private String password;
    
    private String confirmPassword;

    private String designation;
    
    @NotEmpty
    private String email;
    
    private String deptmstcode;
    
    
    
    // Getters and setters
    
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDeptmstcode() {
		return deptmstcode;
	}
	public void setDeptmstcode(String deptmstcode) {
		this.deptmstcode = deptmstcode;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}


   
    
}
