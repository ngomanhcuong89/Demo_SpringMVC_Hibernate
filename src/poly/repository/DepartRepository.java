package poly.repository;

import java.util.List;

import poly.entity.DepartEntity;

public interface DepartRepository 
{
	String save(DepartEntity departEntity);
	String update(DepartEntity departEntity);
	String delete(DepartEntity departEntity);
	List<DepartEntity> findAll();
	DepartEntity findDepartById(String id);
}
