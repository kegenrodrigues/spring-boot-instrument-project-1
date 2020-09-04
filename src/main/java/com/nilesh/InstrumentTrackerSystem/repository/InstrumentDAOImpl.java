package com.nilesh.InstrumentTrackerSystem.repository;

import java.io.File;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
		

		InstrumentEntity dbInstrument = entityManager.merge(theInstrument);
		theInstrument.setInstId(dbInstrument.getInstId());
	}

	@Override
	public void deleteById(String empId) {
		// TODO Auto-generated method stub

	}

	public List<InstrumentEntity> fetchInstrumentList() {
		Query theQuery = entityManager.createNativeQuery("SELECT instId from instrument",InstrumentEntity.class);
		@SuppressWarnings("unchecked")
		List<InstrumentEntity> instList = (List<InstrumentEntity>)theQuery.getResultList();		      
		return instList;
	}

	@Transactional
	public void insertFromCSV(File file) {
		Query theQuery = entityManager.createNativeQuery("LOAD DATA LOCAL INFILE :fileName INTO TABLE instrument");
		theQuery.setParameter("fileName", file.getPath());
		theQuery.executeUpdate();
	}
}
