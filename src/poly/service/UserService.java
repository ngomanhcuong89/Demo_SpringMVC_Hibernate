package poly.service;

import java.util.List;

import poly.dto.UserDTO;

public interface UserService 
{
	String addUser(UserDTO userDTO);
	String update(UserDTO userDTO);
	String delete(String username);
	List<UserDTO> findAll();
	UserDTO findUserByUsername(String username);
	int findUserByUsernameAndPassword(String username, String password);
}
