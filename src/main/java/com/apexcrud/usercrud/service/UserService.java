package com.apexcrud.usercrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.apexcrud.usercrud.dto.UserRegistrationDto;
import com.apexcrud.usercrud.entity.Role;
import com.apexcrud.usercrud.entity.User;
import com.apexcrud.usercrud.exception.UserNotFoundException;
import com.apexcrud.usercrud.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
//    @Autowired
//    private PasswordEncoder passwordEncoder;



    public void registerNewUser(UserRegistrationDto registrationDto) {
        User user = new User();
        user.setUserid(registrationDto.getUserid());
        user.setUsername(registrationDto.getUsername());
        user.setPassword((registrationDto.getPassword()));
        user.setDesignation(registrationDto.getDesignation());
        user.setEmail(registrationDto.getEmail());
        user.setDeptmstcode(registrationDto.getDeptmstcode());
        user.setRole(Role.USER);
        userRepository.save(user);
    }

    public boolean existsByUserid(String userid) {
        return userRepository.existsByUserid(userid);
    }

    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()) {
            return user.get();
        } else {
            throw new UserNotFoundException("User with ID " + id + " not found");
        }
    }

    public String addUser(UserRegistrationDto dto) {
    	
    	User user = new User();
    	BeanUtils.copyProperties(dto, user);
    	
    	if(userRepository.existsByUserid(dto.getUserid())) {
    		throw new UserNotFoundException("User " + dto.getUserid() + " already exist");
    	}
		 userRepository.save(user);
		 return " New User with ID " + user.id + " Created successfully";
    }

    
    
    public String updateUser(Long id, UserRegistrationDto dto) {
        // Fetch the existing user by ID
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User with ID " + id + " not found"));

        // Copy properties from DTO to the existing user
        BeanUtils.copyProperties(dto, existingUser, "id"); // Prevent overwriting ID

        // Save the updated user back to the database
        User updatedUser = userRepository.save(existingUser);
        
        if(updatedUser == null) {
        	return "Something went wrong";
        }
        return " User with ID " + id + " Updated successfully";
         
        
    }

    
    
    public String deleteUser(Long id) {
    	if(!userRepository.existsById(id)) {
    		throw new UserNotFoundException("User with ID " + id + " does not exist");
    	}
        userRepository.deleteById(id);
        return "user with the id " +id+ " has been deleted.";
    }

   
    public List<User> getAllUsers() {
        return userRepository.findAll();  // fetch all users
    }


    public List<User> getUsersByDeptmstcode(String deptmstcode) {
        return userRepository.findByDeptmstcode(deptmstcode);  // fetch users by department code
    }
	
	

	
}
