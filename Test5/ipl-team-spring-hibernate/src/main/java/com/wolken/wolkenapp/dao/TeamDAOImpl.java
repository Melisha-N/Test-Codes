package com.wolken.wolkenapp.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;

import com.wolken.wolkenapp.dto.TeamDTO;

@Component
public class TeamDAOImpl implements TeamDAO{
	
	@Autowired 
	LocalSessionFactoryBean bean;
	
//With hibernate file - hibernate.cfg.xml	
//	@Override
//	public String save(TeamDTO teamDTO) {
//		System.out.println("Inside save - dao");
//		Configuration configuration = bean.getConfiguration();
//		configuration.configure();
//		SessionFactory factory = configuration.buildSessionFactory();
//		Session session = factory.openSession();
//		Transaction transaction = session.beginTransaction();
//		session.save(teamDTO);
//		transaction.commit();
//		session.close();
//		
//		
//		return "Data added succesfully";
//		
//	}
	
	
	@Override
	public String save(TeamDTO teamDTO) {
		System.out.println("Inside save - dao");
		
		
//		BasicDataSource basicDataSource = new BasicDataSource();
//		basicDataSource.getDriverClassName();
//		basicDataSource.getUrl();
//		basicDataSource.getUsername();
//		basicDataSource.getPassword();
		
//		bean.setConfigLocation(""); // it is already configured in myspring.xml(line-12)
		
		SessionFactory sessionFactory = bean.getObject();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		session.save(teamDTO);
		transaction.commit();
		
		session.close();
		
		
		return "Data added succesfully";
		
	}

	

	@Override
	public String deleteByTeamName(String teamName) {
		
		System.out.println("Inside delete - dao");
		SessionFactory sessionFactory = bean.getObject();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query delQ = session.createQuery("delete from TeamDTO ipltd where ipltd.teamName=: name"); 
		delQ.setParameter("name", teamName);
		delQ.executeUpdate();
		transaction.commit();
		session.close();
		System.out.println("End of delete dao");
		return "Data deleted successfully ";
	}
	
	
	@Override
	public List<TeamDTO> getAllData() {
		try {
			SessionFactory sessionFactory = bean.getObject();
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			
			Query getQ = session.createQuery("from TeamDTO");
			List<TeamDTO> tdto = getQ.list();
//			System.out.println("All Library Data");
//			ldto.forEach(System.out::print);
			transaction.commit();
			session.close();
			return tdto;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}



	@Override
	public String update(String captain, String teamName) {
		try {
			SessionFactory sessionFactory = bean.getObject();
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			
			Query upQ = session.createQuery("update TeamDTO dto set dto.teamName =: name where dto.captain =: captain");
			upQ.setParameter("name", teamName);
			upQ.setParameter("captain", captain);
			
			upQ.executeUpdate();
			
			transaction.commit();
			session.close();
			return "Data updated succesfully";
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}

	

}
