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

}
