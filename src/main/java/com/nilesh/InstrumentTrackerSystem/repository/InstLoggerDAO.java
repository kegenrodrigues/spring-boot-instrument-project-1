package com.nilesh.InstrumentTrackerSystem.repository;

import java.util.List;

import com.nilesh.InstrumentTrackerSystem.entity.InstLoggerEntity;

public interface InstLoggerDAO{
	public List<InstLoggerEntity> findAll();
	public InstLoggerEntity findById(String empId);
	public void save(InstLoggerEntity theInstLogger);
	public void deleteById(String empId);
}
