package com.andy.collector.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.andy.collector.dto.UserDTO;
import com.andy.collector.repository.UserRepository;
import com.andy.collector.repository.model.UserDao;

import ma.glasnost.orika.MapperFacade;

/**
 * Service class for user objects. 
 * 
 * @version		0.1 14. July 2020
 * @author 		Andrej Marcan
 */

@Service
public class UserService {
	private BCryptPasswordEncoder encoder;
	private MapperFacade mapperMongo;
	
	@Autowired
	private UserRepository userRepositoryMongo;

	public UserService(@Autowired MapperService mapperService) {
		this.mapperMongo = mapperService.getFacadeMongo();
		this.encoder = new BCryptPasswordEncoder();
	}
	
	//add new user 
	public void addNewUser(UserDTO userDTO) {
		UserDao user = mapperMongo.map(userDTO, UserDao.class);
		String hashPass = encoder.encode(user.getPassword());
		user.setPassword(hashPass);			
		userRepositoryMongo.save(user);
	}
	
	//update user data by id
	public void updateUserbyId(UserDTO userDTO, int id) {
	    userDTO.setId(id);
	    UserDao user = mapperMongo.map(userDTO, UserDao.class);	    
		String hashPass = encoder.encode(user.getPassword());
		user.setPassword(hashPass);	    
		userRepositoryMongo.save(user);    
	}
	
	//delete user by id
	public void deleteUser(int id) {
		userRepositoryMongo.deleteById(id);
	}
	
	//get user by id
	public UserDTO findUser(int id) {
		Optional<UserDao> user = userRepositoryMongo.findById(id);		
		if(user.isPresent()) {
			UserDTO userDTO = mapperMongo.map(user.get(), UserDTO.class);
			return userDTO;
		} else {
			return null;
		}
	}
	
	//get list of all users
	public List<UserDTO> findAllUsers(){
		List<UserDTO> usersDTO = new ArrayList<>();
		List<UserDao> users = userRepositoryMongo.findAll();
		usersDTO = users.stream().map(p -> mapperMongo.map(p, UserDTO.class)).collect(Collectors.toList());
		return usersDTO;
	}
	
	public boolean comparePass(int id, String rawPass) {
		String hashedPass = userRepositoryMongo.findById(id).get().getPassword();
		return encoder.matches(rawPass, hashedPass);
	}
}
