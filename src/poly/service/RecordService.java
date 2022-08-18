package poly.service;

import java.util.List;

import poly.dto.RecordDTO;

public interface RecordService 
{
	String save(RecordDTO recordDTO);
	String update(RecordDTO recordDTO);
	String delete(int id);
	List<RecordDTO> findAll();
	RecordDTO findRecordById(int id);
	List<Object[]> findRecordReport();
}
