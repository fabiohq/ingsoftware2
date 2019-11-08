package com.johnpantoja.service;



import com.johnpantoja.entity.User;


public interface UserService {

	public Iterable<User> getAllUsers();

	public User getUserById(Long id) throws Exception;	
	
	
	public void deleteUser(Long id) throws Exception;
	public User getLoggedUser() throws Exception ;

}
