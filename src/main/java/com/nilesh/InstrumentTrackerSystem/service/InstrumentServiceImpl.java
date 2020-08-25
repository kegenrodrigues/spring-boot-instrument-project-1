package com.nilesh.InstrumentTrackerSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nilesh.InstrumentTrackerSystem.entity.InstrumentEntity;
import com.nilesh.InstrumentTrackerSystem.repository.InstrumentDAOImpl;

@Service
public class InstrumentServiceImpl implements InstrumentService {

	@Autowired
	private InstrumentDAOImpl theInstrumentDAOImpl; 
	
	@Override
	@Transactional
	public List<InstrumentEntity> findAll() {
		// TODO Auto-generated method stub
		return theInstrumentDAOImpl.findAll();
	}

	@Override
	@Transactional
	public InstrumentEntity findById(String empId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void save(InstrumentEntity theInstrument) {
		
		theInstrumentDAOImpl.save(theInstrument);
		
	}

	@Override
	@Transactional
	public void deleteById(String empId) {
		// TODO Auto-generated method stub

	}

}
