package com.nilesh.InstrumentTrackerSystem.repository;

import java.io.File;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
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
		
		Query theQuery = entityManager.createNativeQuery("select empId from employee");
		
		@SuppressWarnings("unchecked")
		List<EmployeeEntity> employees = (List<EmployeeEntity>)theQuery.getResultList();
		return employees;
	}

	@Override
	public EmployeeEntity findById(String theEmpId) {
		EmployeeEntity employee = new EmployeeEntity();

		Query theQuery = entityManager.createNativeQuery("select empId from employee where empId =?1");
		theQuery.setParameter(1, theEmpId);

		Object dEmpId = (Object)theQuery.getSingleResult();
		String result = dEmpId.toString();
		employee.setEmpId(result);
		return employee;
	}

	@Override
	public void save(EmployeeEntity theEmployee) {
		
		EmployeeEntity dbEmployee = entityManager.merge(theEmployee);
		theEmployee.setEmpId(dbEmployee.getEmpId());
	}

	@Override
	public void deleteById(String theEmpId) {
		
		Query theQuery = entityManager.createNativeQuery("delete from employee where empId=?1");
		theQuery.setParameter(1, theEmpId);
		theQuery.executeUpdate();

	}
	
	@Transactional
	public void insertFromCSV(File file) {
		Query theQuery = entityManager.createNativeQuery("LOAD DATA LOCAL INFILE :fileName INTO TABLE employee");
		theQuery.setParameter("fileName", file.getPath());
		theQuery.executeUpdate();	
	}

	public List<EmployeeEntity> fetchEmployeeList() {
	
		Query theQuery = entityManager.createNativeQuery("SELECT empId from employee",EmployeeEntity.class);
		@SuppressWarnings("unchecked")
		List<EmployeeEntity> empList = (List<EmployeeEntity>)theQuery.getResultList();     
		return empList;
	}
	
}
