package com.nilesh.InstrumentTrackerSystem.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nilesh.InstrumentTrackerSystem.entity.EmployeeEntity;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private EntityManager entityManager;
	
	public EmployeeDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public List<EmployeeEntity> findAll() {
		// TODO Auto-generated method stub
		
		Query theQuery = entityManager.createNativeQuery("select empId from employee");
		
		@SuppressWarnings("unchecked")
		List<EmployeeEntity> employees = (List<EmployeeEntity>)theQuery.getResultList();
		System.out.println(employees);
		return employees;
	}

	@Override
	public EmployeeEntity findById(String empId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(EmployeeEntity theEmployee) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(String empId) {
		// TODO Auto-generated method stub

	}

}
