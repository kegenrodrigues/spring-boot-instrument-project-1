package com.nilesh.InstrumentTrackerSystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nilesh.InstrumentTrackerSystem.entity.EmployeeEntity;
import com.nilesh.InstrumentTrackerSystem.repository.EmployeeDAOImpl;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAOImpl employeeDAOImpl;
	
	List<String> stringList = new ArrayList<>();
	
	@Override
	public List<EmployeeEntity> findAll() {
		// TODO Auto-generated method stub
	
		return employeeDAOImpl.findAll();
	}

	@Override
	public EmployeeEntity findById(String empId) {
		// TODO Auto-generated method stub
		return employeeDAOImpl.findById(empId);
	}

	@Override
	public void save(EmployeeEntity theEmployee) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(String empId) {
		// TODO Auto-generated method stub

	}

	public List<String> modifiedFindAll() {
		stringList.add("Hello Bro");
		stringList.add("Whatsup");
		return stringList;
	}
	
}
