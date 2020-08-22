package com.nilesh.InstrumentTrackerSystem.repository;

import java.util.List;

import com.nilesh.InstrumentTrackerSystem.entity.InstrumentEntity;

public interface InstrumentDAO {
	public List<InstrumentEntity> findAll();
	public InstrumentEntity findById(String empId);
	public void save(InstrumentEntity theInstrument);
	public void deleteById(String empId);
}
