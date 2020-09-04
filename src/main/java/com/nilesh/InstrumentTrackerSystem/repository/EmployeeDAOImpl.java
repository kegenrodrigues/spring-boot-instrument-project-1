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
		// TODO Auto-generated method stub
		
		Query theQuery = entityManager.createNativeQuery("select empId from employee");
		
		@SuppressWarnings("unchecked")
		List<EmployeeEntity> employees = (List<EmployeeEntity>)theQuery.getResultList();
		return employees;
	}

	@Override
	public EmployeeEntity findById(String empId) {
		EmployeeEntity employee = new EmployeeEntity();
//		Session currentSession = entityManager.unwrap(Session.class);
//		EmployeeEntity employee = currentSession.get(EmployeeEntity.class, empId);
//		System.out.println(employee);
//		return employee;
//		EmployeeEntity employee = entityManager.find(EmployeeEntity.class, empId);
//		System.out.println(employee);
//		return employee;
		
		// TODO Auto-generated method stub
		Query theQuery = entityManager.createNativeQuery("select empId from employee where empId =?1");
		theQuery.setParameter(1, "E101");
//		System.out.println(theQuery.getFirstResult());
//can use[E101]		System.out.println(theQuery.getResultList());
//		System.out.println(theQuery.getResultStream());
//can use E101	System.out.println(theQuery.getSingleResult());
//		System.out.println(theQuery.getParameters());
//		
//		System.out.println(theQuery.getClass()); 
		Object dEmpId = (Object)theQuery.getSingleResult();
		String result = dEmpId.toString();
		employee.setEmpId(result);
		return employee;
	}

	@Override
	public void save(EmployeeEntity theEmployee) {
		// TODO Auto-generated method stub
		
		EmployeeEntity dbEmployee = entityManager.merge(theEmployee);
		theEmployee.setEmpId(dbEmployee.getEmpId());
	}

	@Override
	public void deleteById(String empId) {
		// TODO Auto-generated method stub
		
		Query theQuery = entityManager.createNativeQuery("delete from employee where empId=?1");
		theQuery.setParameter(1, empId);
		theQuery.executeUpdate();

	}
	
	@Transactional
	public void insertFromCSV(File file) {
		//entityManager.createQuery("LOAD DATA INFILE :fileName INTO TABLE test").setParameter("fileName", "C:\\samples\\test\\abcd.csv").executeUpdate();
		
		Query query1 = entityManager.createNativeQuery("delete from employee");
		query1.executeUpdate();
		
		Query query2 = entityManager.createNativeQuery("insert into database");
		
//		Query query2 = entityManager.createNativeQuery("LOAD DATA LOCAL INFILE :fileName INTO TABLE employee");
//		query2.setParameter("fileName", file.getPath());
//		query2.executeUpdate();
//		//session.createSQLQuery("LOAD DATA INFILE :filename INTO TABLE testtable (text,price)").setString("filename", "/path/to/MyFile.csv").executeUpdate();
		
	}

	public List<EmployeeEntity> fetchEmployeeList() {
		// TODO Auto-generated method stub

		
		Query theQuery = entityManager.createNativeQuery("SELECT empId from employee",EmployeeEntity.class);
		@SuppressWarnings("unchecked")
		List<EmployeeEntity> empList = (List<EmployeeEntity>)theQuery.getResultList();

			      
		return empList;
	}
	
	
	
}
