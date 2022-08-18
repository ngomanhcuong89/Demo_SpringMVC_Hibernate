package poly.repository.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import poly.entity.DepartEntity;
import poly.repository.DepartRepository;

@Repository
public class DepartRepositoryImpl implements DepartRepository
{
	@Autowired
	SessionFactory factory;
	
	@Override
	public String save(DepartEntity departEntity) 
	{
		String thongbao = "";
		Session session = factory.openSession();
		Transaction trans = session.beginTransaction();
		try 
		{
			session.save(departEntity);
			trans.commit();
			thongbao += "success";
		}
		catch(Exception ex) 
		{
			trans.rollback();
			thongbao += "failed: "+ex.toString();
		}
		finally 
		{
			session.close();
		}
		
		return thongbao;
	}
	
	@Override
	public String update(DepartEntity departEntity) 
	{
		String thongbao = "";
		Session session = factory.openSession();
		Transaction trans = session.beginTransaction();
		try 
		{
			session.update(departEntity);
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
	public String delete(DepartEntity departEntity) 
	{
		String thongbao = "";
		Session session = factory.openSession();
		Transaction trans = session.beginTransaction();
		try 
		{
			session.delete(departEntity);
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
	public List<DepartEntity> findAll()
	{
		Session session = factory.getCurrentSession();
		String queryDepart = "FROM DepartEntity";
		Query query = session.createQuery(queryDepart);
		return query.list();
	}
	
	@Override
	@Transactional
	public DepartEntity findDepartById(String id) 
	{
		Session session = factory.getCurrentSession();
		return (DepartEntity) session.get(DepartEntity.class, id);
	}
}
