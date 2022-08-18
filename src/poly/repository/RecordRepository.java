package poly.repository;

import java.util.List;

import poly.entity.RecordEntity;

public interface RecordRepository 
{
	String save(RecordEntity recordEntity);
	String update(RecordEntity recordEntity);
	String delete(RecordEntity recordEntity);
	List<RecordEntity> findAll();
	RecordEntity findRecordById(int id);
	List<Object[]> findRecordReport();
}
