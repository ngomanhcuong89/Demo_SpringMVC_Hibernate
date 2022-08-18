package poly.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.dto.UserDTO;
import poly.entity.StaffEntity;
import poly.entity.UserEntity;
import poly.repository.StaffRepository;
import poly.repository.UserRepository;
import poly.service.UserService;

@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	UserRepository userRepository;
	@Autowired
	StaffRepository staffRepository;
	
	@Override
	public String addUser(UserDTO userDTO) 
	{
		StaffEntity staffEntity = staffRepository.findStaffById(userDTO.getStaffId());
		UserEntity userEntity = new UserEntity(userDTO.getUsername(), userDTO.getPassword(), userDTO.getFullname(), userDTO.isIsadmin(), staffEntity);
		String thongbao = userRepository.addUser(userEntity);
		return thongbao;
	}
	
	@Override
	public String update(UserDTO userDTO) 
	{
		StaffEntity staffEntity = staffRepository.findStaffById(userDTO.getStaffId());
		UserEntity userEntity = new UserEntity(userDTO.getUsername(), userDTO.getPassword(), userDTO.getFullname(), userDTO.isIsadmin(), staffEntity);
		String thongbao = userRepository.update(userEntity);
		return thongbao;
	}
	
	@Override
	public String delete(String username) 
	{
		UserEntity userEntity = userRepository.findUserByUsername(username);
		String thongbao = userRepository.delete(userEntity);
		return thongbao;
	}
	
	@Override
	public List<UserDTO> findAll()
	{
		List<UserEntity> usersEntity = userRepository.findAll();
		List<UserDTO> usersDTO = new ArrayList<UserDTO>();
		for(UserEntity item : usersEntity) 
		{
			UserDTO userDTO = new UserDTO(item.getUsername(),item.getPassword(), item.getFullname(), item.isIsadmin(), item.getStaff().getId());
			usersDTO.add(userDTO);
		}
		return usersDTO;
	}
	
	@Override
	public UserDTO findUserByUsername(String username) 
	{
		UserEntity userEntity = userRepository.findUserByUsername(username);
		UserDTO userDTO = new UserDTO(userEntity.getUsername(), userEntity.getPassword(), userEntity.getFullname(), userEntity.isIsadmin(), userEntity.getStaff().getId());
		return userDTO;
	}
	
	@Override
	public int findUserByUsernameAndPassword(String username, String password) 
	{
		int check = userRepository.findUserByUsernameAndPassword(username, password);
		return check;
	}
}
