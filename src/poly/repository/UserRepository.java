package poly.repository;

import java.util.List;

import poly.entity.UserEntity;

public interface UserRepository 
{
	String addUser(UserEntity userEntity);
	String update(UserEntity userEntity);
	String delete(UserEntity userEntity);
	List<UserEntity> findAll();
	UserEntity findUserByUsername(String username);
	int findUserByUsernameAndPassword(String username, String password);
}
