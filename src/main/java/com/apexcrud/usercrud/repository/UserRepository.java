package com.apexcrud.usercrud.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.apexcrud.usercrud.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
	
    Optional<User> findByUserid(String userid); // Used for finding users by user ID
    
    boolean existsByUserid(String userid);
    
	Object findByUsername(String username);

	List<User> findByDeptmstcode(String deptmstcode);
}
