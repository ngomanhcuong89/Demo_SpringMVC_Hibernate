package poly.service;

import java.util.List;

import poly.dto.StaffDTO;

public interface StaffService 
{
	String addStaff(StaffDTO staffDTO);
	String update(StaffDTO staffDTO);
	String delete(String id);
	List<StaffDTO> findAll();
	StaffDTO findStaffById(String id);
}
