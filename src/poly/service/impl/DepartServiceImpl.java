package poly.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.dto.DepartDTO;
import poly.entity.DepartEntity;
import poly.repository.DepartRepository;
import poly.service.DepartService;

@Service
public class DepartServiceImpl implements DepartService
{
	@Autowired
	DepartRepository departRepository;
	
	@Override
	public String save(DepartDTO departDTO) 
	{
		DepartEntity departEntity = new DepartEntity(departDTO.getId(), departDTO.getName());
		String thongbao = departRepository.save(departEntity);
		return thongbao;
	}
	
	@Override
	public String update(DepartDTO departDTO) 
	{
		DepartEntity departEntity = new DepartEntity(departDTO.getId(), departDTO.getName());
		String thongbao = departRepository.update(departEntity);
		return thongbao;
	}
	
	@Override
	public String delete(String id) 
	{
		DepartEntity departEntity = departRepository.findDepartById(id);
		String thongbao = departRepository.delete(departEntity);
		return thongbao;
	}
	
	@Override
	public List<DepartDTO> findAll()
	{
		List<DepartEntity> departsEntity = departRepository.findAll();
		List<DepartDTO> departsDTO = new ArrayList<DepartDTO>();
		for(DepartEntity item:departsEntity) 
		{
			DepartDTO departDTO = new DepartDTO(item.getId(),item.getName());
			departsDTO.add(departDTO);
		}
		return departsDTO;
	}
	
	@Override
	public DepartDTO findDepartById(String id) 
	{
		DepartEntity departEntity = departRepository.findDepartById(id);
		DepartDTO departDTO = new DepartDTO(departEntity.getId(), departEntity.getName());
		return departDTO;
	}
}
