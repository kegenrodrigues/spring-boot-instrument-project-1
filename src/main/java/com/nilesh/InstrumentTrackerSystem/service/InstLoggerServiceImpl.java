package com.nilesh.InstrumentTrackerSystem.service;

import java.util.Calendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.nilesh.InstrumentTrackerSystem.entity.InstLoggerEntity;
import com.nilesh.InstrumentTrackerSystem.repository.InstLoggerDAOImpl;

@Service
public class InstLoggerServiceImpl implements InstLoggerService {

	@Autowired
	private InstLoggerDAOImpl theInstLoggerDAOImpl;
	
	@Override
	@Transactional
	public List<InstLoggerEntity> findAll() {
		// TODO Auto-generated method stub
		return theInstLoggerDAOImpl.findAll();
	}

	@Override
	@Transactional
	public InstLoggerEntity findById(Long instLoggerId) {
		// TODO Auto-generated method stub
		return theInstLoggerDAOImpl.findById(instLoggerId);
	}

	@Override
	@Transactional
	public void save(InstLoggerEntity theInstLogger) {
		theInstLoggerDAOImpl.save(theInstLogger);

	}

	@Override
	@Transactional
	public void deleteById(Long instLoggerId) {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional
	public List<InstLoggerEntity> insertToTable(Calendar punchingTime, String empId, String instId) {
		// TODO Auto-generated method stub
		return theInstLoggerDAOImpl.insertToTable(punchingTime, empId, instId);
	}

	@Override
	@Transactional
	public List<InstLoggerEntity> fetchListFor() {
		// TODO Auto-generated method stub
		return theInstLoggerDAOImpl.fetchListFor();
	}

	@Override
	@Transactional
	public List<InstLoggerEntity> unReturnedItems() {
		// TODO Auto-generated method stub
		return theInstLoggerDAOImpl.unReturnedItems();
	}

}
