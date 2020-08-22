package com.nilesh.InstrumentTrackerSystem.service;

import java.util.List;

import com.nilesh.InstrumentTrackerSystem.entity.EmployeeEntity;

public interface EmployeeService {

	public List<EmployeeEntity> findAll();
	public EmployeeEntity findById(String empId);
	public void save(EmployeeEntity theEmployee);
	public void deleteById(String empId);
	
}
