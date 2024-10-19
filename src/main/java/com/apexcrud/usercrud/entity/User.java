package com.apexcrud.usercrud.entity;

import java.util.List;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "users_info")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
    
    @Column(nullable = false, unique = true)
    private String userid;
    
  
    private String username;
    
    private String password;
    
    private String designation;
    
    @Email
    private String email;
    
    private String deptmstcode;

    @Enumerated(EnumType.STRING)
    private Role role;
    
    
    
    
    
    // Getters and setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public void addAttribute(String string, List<User> userList) {
		// TODO Auto-generated method stub
		
	}

	
  
    
}


