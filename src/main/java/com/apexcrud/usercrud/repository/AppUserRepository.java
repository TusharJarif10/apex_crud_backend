package com.apexcrud.usercrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apexcrud.usercrud.entity.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {

	public AppUser findByUserid (String userid);
}
