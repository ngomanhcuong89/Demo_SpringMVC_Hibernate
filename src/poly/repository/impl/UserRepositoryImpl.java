package poly.repository.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import poly.entity.UserEntity;
import poly.repository.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository
{
	@Autowired
	SessionFactory factory;
	
	@Override
	public String addUser(UserEntity userEntity) 
	{
		String thongbao = "";
		Session session = factory.openSession();
		Transaction trans = session.beginTransaction();
		try 
		{
			session.save(userEntity);
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
	public String update(UserEntity userEntity) 
	{
		String thongbao = "";
		Session session = factory.openSession();
		Transaction trans = session.beginTransaction();
		try 
		{
			session.update(userEntity);
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
	public String delete(UserEntity userEntity) 
	{
		String thongbao = "";
		Session session = factory.openSession();
		Transaction trans = session.beginTransaction();
		try 
		{
			session.delete(userEntity);
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
	@Transactional
	public List<UserEntity> findAll()
	{
		Session session = factory.getCurrentSession();
		String queryUser = "FROM UserEntity";
		Query query = session.createQuery(queryUser);
		return query.list();
	}
	
	@Override
	@Transactional
	public UserEntity findUserByUsername(String username) 
	{
		Session session = factory.getCurrentSession();
		UserEntity userEntity = (UserEntity)session.get(UserEntity.class, username); 
		return userEntity;
	}
	
	@Override
	@Transactional
	public int findUserByUsernameAndPassword(String username, String password)
	{
		Session session = factory.getCurrentSession();
		String queryUser = "SELECT COUNT(*) FROM UserEntity u WHERE u.username = :user and u.password = :pass";
		Query query = session.createQuery(queryUser);
		query.setParameter("user", username);
		query.setParameter("pass", password);
		return (int)((long)query.uniqueResult());
	}
}
