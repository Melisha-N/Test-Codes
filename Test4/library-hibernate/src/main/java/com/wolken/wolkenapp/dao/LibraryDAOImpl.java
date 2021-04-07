package com.wolken.wolkenapp.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mel.melapp.HibernateUtil;
import com.wolken.wolkenapp.dto.LibraryDTO;

public class LibraryDAOImpl implements LibraryDAO {

	@Override
	public void addLibraryData(LibraryDTO libraryDTO) {
		try {
			Session session = HibernateUtil.getFactory().openSession();
			Transaction transaction = session.beginTransaction();
			session.save(libraryDTO);
			transaction.commit();
			session.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void updateDataByBookName(String bookName, int noOfBooks) {
		try {
			Session session  = HibernateUtil.getFactory().openSession();
			Transaction  transaction = session.beginTransaction();
			Query upQ = session.getNamedQuery("updateLibData");
			upQ.setParameter("nbks", noOfBooks);
			upQ.setParameter("bnm", bookName);
			upQ.executeUpdate();
			transaction.commit();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
				
	}

	@Override
	public List<LibraryDTO> getAllData(LibraryDTO libraryDTO) {
		try {
			Session session = HibernateUtil.getFactory().openSession();
			Query getQ = session.getNamedQuery("getLibData");
			List<LibraryDTO> ldto = getQ.list();
			System.out.println("All Library Data");
			ldto.forEach(System.out::print);
			session.close();
			return ldto;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public boolean deleteDataByLibraryName(String libraryName) {
		try {
			Session session = HibernateUtil.getFactory().openSession();
			Transaction transaction = session.beginTransaction();
			Query delQ = session.createQuery("delete from LibraryDTO lib where lib.libraryName=:lnm");
			if(delQ != null) {
			delQ.setParameter("lnm", libraryName);
			delQ.executeUpdate();
			transaction.commit();
			session.close();
			return true;
			}
			else {
				return false;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
		
	}

	
	
}
