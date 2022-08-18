package poly.repository.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import poly.entity.RecordEntity;
import poly.repository.RecordRepository;

@Repository
public class RecordRepositoryImpl implements RecordRepository
{
	@Autowired
	SessionFactory factory;
	
	@Override
	public String save(RecordEntity recordEntity) 
	{
		String thongbao = "";
		Session session = factory.openSession();
		Transaction trans = session.beginTransaction();
		try 
		{
			session.save(recordEntity);
			trans.commit();
			thongbao += "Save Success";
		}
		catch(Exception ex) 
		{
			trans.rollback();
			thongbao += "Save Failed "+ex.toString() ;
		}
		finally 
		{
			session.close();
		}
		return thongbao;
	}
	
	@Override
	public String update(RecordEntity recordEntity) 
	{
		String thongbao = "";
		Session session = factory.openSession();
		Transaction trans = session.beginTransaction();
		try 
		{
			String queryUpdate = "UPDATE RecordEntity SET type = :type, reason = :reason, date = :date, staff = :staff WHERE id = :id";
			Query query = session.createQuery(queryUpdate);
			query.setParameter("type", recordEntity.isType());
			query.setParameter("reason", recordEntity.getReason());
			query.setParameter("date", recordEntity.getDate());
			query.setParameter("staff", recordEntity.getStaff());
			query.setParameter("id", recordEntity.getId());
			int executeUpdate = query.executeUpdate();
			
//			session.save(recordEntity);
			trans.commit();
			thongbao += "Update Success "+executeUpdate;
		}
		catch(Exception ex) 
		{
			trans.rollback();
			thongbao += "Update Failed "+ex.toString();
		}
		finally 
		{
			session.close();
		}
		return thongbao;
	}
	
	@Override
	public String delete(RecordEntity recordEntity) 
	{
		String thongbao = "";
		Session session = factory.openSession();
		Transaction trans = session.beginTransaction();
		try 
		{
			session.delete(recordEntity);
			trans.commit();
			thongbao += "Delete Success";
		}
		catch(Exception ex) 
		{
			trans.rollback();
			thongbao += "Delete Failed";
		}
		finally 
		{
			session.close();
		}
		return thongbao;
	}
	
	@Override
	@Transactional
	public List<RecordEntity> findAll()
	{
		Session session = factory.getCurrentSession();
		String queryfindall = "FROM  RecordEntity";
		Query query = session.createQuery(queryfindall);
		return query.list();
	}
	
	@Override
	@Transactional
	public RecordEntity findRecordById(int id) 
	{
		Session session = factory.getCurrentSession();
		return (RecordEntity)session.get(RecordEntity.class, id);
	}
	
	@Override
	@Transactional
	public List<Object[]> findRecordReport() 
	{
		Session session = factory.getCurrentSession();
		String queryReport = "SELECT staff.id, SUM(case when type=1 then 1 else 0 end), SUM(case when type=0 then 1 else 0 end) FROM RecordEntity GROUP BY staff.id";
		Query query = session.createQuery(queryReport);
		return query.list();
	}
}
