package com.nilesh.InstrumentTrackerSystem.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//import com.nilesh.InstrumentTrackerSystem.entity.EmployeeEntity;
import com.nilesh.InstrumentTrackerSystem.entity.InstLoggerEntity;

@Repository
public class InstLoggerDAOImpl implements InstLoggerDAO {

	@Autowired
	private EntityManager entityManager;
	
	public InstLoggerDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public List<InstLoggerEntity> findAll() {
		// TODO Auto-generated method stub
		Query theQuery = entityManager.createNativeQuery("select instLoggerId from instLogger");
		
		@SuppressWarnings("unchecked")
		List<InstLoggerEntity> instLogger = (List<InstLoggerEntity>)theQuery.getResultList();
		System.out.println(instLogger);
		return instLogger;
	}

	@Override
	public InstLoggerEntity findById(String instLoggerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(InstLoggerEntity theInstLogger) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(String instLoggerId) {
		// TODO Auto-generated method stub

	}

}
