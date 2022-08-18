package poly.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.dto.StaffDTO;
import poly.entity.DepartEntity;
import poly.entity.StaffEntity;
import poly.repository.DepartRepository;
import poly.repository.StaffRepository;
import poly.service.StaffService;

@Service
public class StaffServiceImpl implements StaffService
{
	@Autowired
	StaffRepository staffRepository;
	@Autowired
	DepartRepository departRepository;
	
	@Override
	public String addStaff(StaffDTO staffDTO) 
	{
		DepartEntity departEntity = departRepository.findDepartById(staffDTO.getDepartId());
		
		StaffEntity staffEntity = new StaffEntity();
		staffEntity.setId(staffDTO.getId());
		staffEntity.setName(staffDTO.getName());
		staffEntity.setGender(staffDTO.isGender());
		staffEntity.setBirthday(staffDTO.getBirthday());
		staffEntity.setPhoto(staffDTO.getPhoto());
		staffEntity.setEmail(staffDTO.getEmail());
		staffEntity.setPhone(staffDTO.getPhone());
		staffEntity.setSalary(staffDTO.getSalary());
		staffEntity.setNote(staffDTO.getNote());
		staffEntity.setDepart(departEntity);
		
		String thongbao = staffRepository.addStaff(staffEntity);
		return thongbao;
	}
	
	@Override
	public String update(StaffDTO staffDTO)
	{
		DepartEntity departEntity = departRepository.findDepartById(staffDTO.getDepartId());
		StaffEntity staffEntity = new StaffEntity();
		staffEntity.setId(staffDTO.getId());
		staffEntity.setName(staffDTO.getName());
		staffEntity.setGender(staffDTO.isGender());
		staffEntity.setBirthday(staffDTO.getBirthday());
		staffEntity.setPhoto(staffDTO.getPhoto());
		staffEntity.setEmail(staffDTO.getEmail());
		staffEntity.setPhone(staffDTO.getPhone());
		staffEntity.setSalary(staffDTO.getSalary());
		staffEntity.setNote(staffDTO.getNote());	
		staffEntity.setDepart(departEntity);
		
		String thongbao = staffRepository.update(staffEntity);
		return thongbao;
	}
	
	@Override
	public String delete(String id) 
	{
		StaffEntity staffEntity = staffRepository.findStaffById(id);
		return staffRepository.delete(staffEntity);
	}
	
	@Override
	public List<StaffDTO> findAll()
	{
		List<StaffEntity> staffsEntity = staffRepository.findAll();
		List<StaffDTO> staffsDTO = new ArrayList<StaffDTO>();
		for(StaffEntity item:staffsEntity) 
		{
			StaffDTO staffDTO = new StaffDTO(item.getId(), item.getName(), item.isGender(), item.getBirthday(), item.getPhoto(), item.getEmail(), 
					item.getPhone(), item.getSalary(), item.getNote(), item.getDepart().getId());
			staffsDTO.add(staffDTO);
		}
		return staffsDTO;
	}
	
	@Override
	public StaffDTO findStaffById(String id) 
	{
		StaffEntity staffEntity = staffRepository.findStaffById(id);
		StaffDTO staffDTO = new StaffDTO(staffEntity.getId(), staffEntity.getName(), staffEntity.isGender(), 
				staffEntity.getBirthday(), staffEntity.getPhoto(), staffEntity.getEmail(), staffEntity.getPhone(), 
				staffEntity.getSalary(), staffEntity.getNote(), staffEntity.getDepart().getId());
		return staffDTO;
	}
}
