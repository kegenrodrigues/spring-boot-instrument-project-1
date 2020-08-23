package com.nilesh.InstrumentTrackerSystem.service;

import java.util.List;

import com.nilesh.InstrumentTrackerSystem.entity.InstLoggerEntity;

public interface InstLoggerService {
	public List<InstLoggerEntity> findAll();
	public InstLoggerEntity findById(String instLoggerId);
	public void save(InstLoggerEntity theInstLogger);
	public void deleteById(String instLoggerId);
	public List<InstLoggerEntity> findByPair(String empId, String instId);
}
