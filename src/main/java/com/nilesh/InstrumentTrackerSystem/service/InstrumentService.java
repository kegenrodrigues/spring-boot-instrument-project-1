package com.nilesh.InstrumentTrackerSystem.service;

import java.util.List;

import com.nilesh.InstrumentTrackerSystem.entity.InstrumentEntity;

public interface InstrumentService {
	public List<InstrumentEntity> findAll();
	public InstrumentEntity findById(String empId);
	public void save(InstrumentEntity theInstrument);
	public void deleteById(String empId);
}
