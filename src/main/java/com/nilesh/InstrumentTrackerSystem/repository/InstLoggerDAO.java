package com.nilesh.InstrumentTrackerSystem.repository;


import java.util.Date;
import java.util.List;

import com.nilesh.InstrumentTrackerSystem.entity.InstLoggerEntity;

public interface InstLoggerDAO{
	public List<InstLoggerEntity> findAll();
	public InstLoggerEntity findById(String instLoggerId);
	public void save(InstLoggerEntity theInstLogger);
	public void deleteById(String instLoggerId);
	public List<InstLoggerEntity> findByPair(String empId, String instId);
	public List<InstLoggerEntity> findAll(Date startTime,Date inTime,Date timeNow, String empId,String instId);
	
}
