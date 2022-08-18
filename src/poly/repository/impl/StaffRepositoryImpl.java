package poly.repository.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import poly.entity.StaffEntity;
import poly.repository.StaffRepository;

@Repository
public class StaffRepositoryImpl implements StaffRepository
{
	@Autowired
	SessionFactory factory;
	
	@Override
	public String addStaff(StaffEntity staffEntity) 
	{
		String thongbao = "";
		Session session = factory.openSession();
		Transaction trans = session.beginTransaction();
		try 
		{
			session.save(staffEntity);
			trans.commit();
			thongbao += "success";
		}
		catch(Exception ex) 
		{
			trans.rollback();
			thongbao += "failed";
		}
		finally 
		{
			session.close();
		}
		return thongbao;
	}
	
	@Override
	public String update(StaffEntity staffEntity) 
	{
		String thongbao = "";
		Session session = factory.openSession();
		Transaction trans = session.beginTransaction();
		try 
		{
			session.update(staffEntity);
			trans.commit();
			thongbao += "success";
		}
		catch(Exception ex) 
		{
			trans.rollback();
			thongbao += "failed";
		}
		finally 
		{
			session.close();
		}
		return thongbao;
	}
	
	@Override
	public String delete(StaffEntity staffEntity) 
	{
		String thongbao = "";
		Session session = factory.openSession();
		Transaction trans = session.beginTransaction();
		try 
		{
			session.delete(staffEntity);
			trans.commit();
			thongbao += "Delete Success";
		}
		catch(Exception ex) 
		{
			trans.rollback();
			thongbao += "Delete Failed "+ex.toString();
		}
		finally 
		{
			session.close();
		}
		return thongbao;
	}
	
	@Override
	@Transactional
	public List<StaffEntity> findAll()
	{
		Session session = factory.getCurrentSession();
		String queryStaff = "FROM StaffEntity";
		Query query = session.createQuery(queryStaff);
		return query.list();
	}
	
	@Override
	@Transactional
	public StaffEntity findStaffById(String id) 
	{
		Session session = factory.getCurrentSession();
		StaffEntity staffEntity = (StaffEntity)session.get(StaffEntity.class, id);
		return staffEntity;
	}
}
