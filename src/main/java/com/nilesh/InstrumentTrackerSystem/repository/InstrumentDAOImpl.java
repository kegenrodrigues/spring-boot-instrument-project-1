package com.nilesh.InstrumentTrackerSystem.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//import com.nilesh.InstrumentTrackerSystem.entity.InstLoggerEntity;
import com.nilesh.InstrumentTrackerSystem.entity.InstrumentEntity;

@Repository
public class InstrumentDAOImpl implements InstrumentDAO {

	@Autowired
	private EntityManager entityManager;
	
	public InstrumentDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public List<InstrumentEntity> findAll() {
		Query theQuery = entityManager.createNativeQuery("select instLoggerId from instLogger");
		
		@SuppressWarnings("unchecked")
		List<InstrumentEntity> theInstrument = (List<InstrumentEntity>)theQuery.getResultList();
		System.out.println(theInstrument);
		return theInstrument;
	}

	@Override
	public InstrumentEntity findById(String empId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(InstrumentEntity theInstrument) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(String empId) {
		// TODO Auto-generated method stub

	}

}
