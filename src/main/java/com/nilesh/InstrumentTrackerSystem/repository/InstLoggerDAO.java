package com.nilesh.InstrumentTrackerSystem.repository;


import java.util.Calendar;
import java.util.List;

import com.nilesh.InstrumentTrackerSystem.entity.InstLoggerEntity;

public interface InstLoggerDAO{
	public List<InstLoggerEntity> findAll();
	public InstLoggerEntity findById(Long instLoggerId);
	public void save(InstLoggerEntity theInstLogger);
	public void deleteById(Long instLoggerId);
	public List<InstLoggerEntity> findByPair(String empId, String instId);
	public List<InstLoggerEntity> findByPair(Calendar startTime,Calendar inTime,Calendar outTime,Calendar timeNow, String empId,String instId);
	public List<InstLoggerEntity> insertToTable(Calendar punchingTime,String empId, String instId);
	
}
