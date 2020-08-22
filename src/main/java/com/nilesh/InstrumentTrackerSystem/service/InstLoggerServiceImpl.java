package com.nilesh.InstrumentTrackerSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nilesh.InstrumentTrackerSystem.entity.InstLoggerEntity;
import com.nilesh.InstrumentTrackerSystem.repository.InstLoggerDAOImpl;

@Service
public class InstLoggerServiceImpl implements InstLoggerService {

	@Autowired
	private  InstLoggerDAOImpl theInstLoggerDAOImpl;
	
	
	@Override
	public List<InstLoggerEntity> findAll() {
		// TODO Auto-generated method stub
		return theInstLoggerDAOImpl.findAll();
	}

	@Override
	public InstLoggerEntity findById(String empId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(InstLoggerEntity theInstLogger) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(String empId) {
		// TODO Auto-generated method stub

	}

}
