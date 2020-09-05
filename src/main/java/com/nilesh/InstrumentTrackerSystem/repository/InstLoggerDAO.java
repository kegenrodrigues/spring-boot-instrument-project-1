package com.nilesh.InstrumentTrackerSystem.repository;

import java.util.Calendar;
import java.util.List;

import com.nilesh.InstrumentTrackerSystem.entity.InstLoggerEntity;

public interface InstLoggerDAO{
	public List<InstLoggerEntity> findAll();
	public InstLoggerEntity findById(Long instLoggerId);
	public void save(InstLoggerEntity theInstLogger);
	public void deleteById(Long instLoggerId);
	public List<InstLoggerEntity> insertToTable(Calendar punchingTime,String empId, String instId,String modelNo, String iP);
	public List<InstLoggerEntity> fetchListFor();
	public List<InstLoggerEntity> unReturnedItems();
}
