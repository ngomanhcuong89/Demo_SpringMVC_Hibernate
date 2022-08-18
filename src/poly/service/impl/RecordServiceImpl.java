package poly.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.dto.RecordDTO;
import poly.entity.RecordEntity;
import poly.entity.StaffEntity;
import poly.repository.RecordRepository;
import poly.repository.StaffRepository;
import poly.service.RecordService;

@Service
public class RecordServiceImpl implements RecordService
{
	@Autowired
	RecordRepository recordRepository;
	@Autowired
	StaffRepository staffRepository;
	
	@Override
	public String save(RecordDTO recordDTO) 
	{
		StaffEntity staffEntity = staffRepository.findStaffById(recordDTO.getStaffId());
		RecordEntity recordEntity = new RecordEntity(recordDTO.getId(), recordDTO.isType(), recordDTO.getReason(), recordDTO.getDate(), staffEntity);
		String thongbao = recordRepository.save(recordEntity);
		return thongbao;
	}
	
	@Override
	public String update(RecordDTO recordDTO) 
	{
		StaffEntity staffEntity = staffRepository.findStaffById(recordDTO.getStaffId());
		RecordEntity recordEntity = new RecordEntity(recordDTO.getId(),recordDTO.isType(), recordDTO.getReason(), recordDTO.getDate(),staffEntity);
		String thongbao = recordRepository.update(recordEntity);
		return thongbao;
	}
	
	@Override
	public String delete(int id) 
	{
		RecordEntity recordEntity = recordRepository.findRecordById(id);
		String thongbao = recordRepository.delete(recordEntity);
		return thongbao;
	}
	
	@Override
	public List<RecordDTO> findAll()
	{
		List<RecordEntity> recordsEntity = recordRepository.findAll();
		List<RecordDTO> recordsDTO = new ArrayList<RecordDTO>();
		for(RecordEntity item:recordsEntity) 
		{
			RecordDTO recordDTO = new RecordDTO(item.getId(), item.isType(), item.getReason(), item.getDate(), item.getStaff().getId());
			recordsDTO.add(recordDTO);
		}
		
		return recordsDTO;
	}
	
	@Override
	public RecordDTO findRecordById(int id) 
	{
		RecordEntity recordEntity = recordRepository.findRecordById(id);
		RecordDTO recordDTO = new RecordDTO(recordEntity.getId(), recordEntity.isType(), recordEntity.getReason(), recordEntity.getDate(), recordEntity.getStaff().getId());
		return recordDTO;
	}
	
	@Override
	public List<Object[]> findRecordReport()
	{
		return recordRepository.findRecordReport();
	}
}