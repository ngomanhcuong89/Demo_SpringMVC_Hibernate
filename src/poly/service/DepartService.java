package poly.service;

import java.util.List;

import poly.dto.DepartDTO;

public interface DepartService 
{
	String save(DepartDTO departDTO);
	String update(DepartDTO departDTO);
	String delete(String id);
	List<DepartDTO> findAll();
	DepartDTO findDepartById(String id);
}
