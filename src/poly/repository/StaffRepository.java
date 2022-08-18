package poly.repository;

import java.util.List;

import poly.entity.StaffEntity;

public interface StaffRepository 
{
	String addStaff(StaffEntity staffEntity);
	String update(StaffEntity staffEntity);
	String delete(StaffEntity staffEntity);
	List<StaffEntity> findAll();
	StaffEntity findStaffById(String id);
}
