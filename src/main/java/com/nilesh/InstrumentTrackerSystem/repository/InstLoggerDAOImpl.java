package com.nilesh.InstrumentTrackerSystem.repository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

//import com.nilesh.InstrumentTrackerSystem.entity.EmployeeEntity;
import com.nilesh.InstrumentTrackerSystem.entity.InstLoggerEntity;

@Repository
public class InstLoggerDAOImpl implements InstLoggerDAO {

	@Autowired
	private EntityManager entityManager;
	
	public InstLoggerDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public List<InstLoggerEntity> findAll() {
		// TODO Auto-generated method stub
		Query theQuery = entityManager.createNativeQuery("select instLoggerId from instLogger");
		
		@SuppressWarnings("unchecked")
		List<InstLoggerEntity> instLogger = (List<InstLoggerEntity>)theQuery.getResultList();
		System.out.println(instLogger);
		return instLogger;
	}

	@Override
	public InstLoggerEntity findById(Long instLoggerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(InstLoggerEntity theInstLogger) {

		InstLoggerEntity dbInstLogger = entityManager.merge(theInstLogger);
		theInstLogger.setInstLoggerId(dbInstLogger.getInstLoggerId());
	}

	@Override
	public void deleteById(Long instLoggerId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<InstLoggerEntity> findByPair(String empId, String instId) {
		
		Query theQuery = entityManager.createNativeQuery("select * from instLogger where empId = ?1 and instId = ?2 and outTime = (Select Max(outTime) from instLogger where instId = ?2 group by empId,instId)",InstLoggerEntity.class);
		theQuery.setParameter(1, empId);
		theQuery.setParameter(2, instId);
		
		@SuppressWarnings("unchecked")
		List<InstLoggerEntity> instLogger = (List<InstLoggerEntity>)theQuery.getResultList();
		System.out.println(instLogger.get(0).getInstLoggerId());
		
		return instLogger;
	}

	@Override
	public List<InstLoggerEntity> findByPair(Calendar startTime, Calendar inTime, Calendar outTime, Calendar timeNow, String empId, String instId) {
		// TODO Auto-generated method stub
		Query theQuery = entityManager.createNativeQuery("SELECT * from instLogger where empId = ?1 and instId = ?2 and outTime = (Select Max(outTime) from instLogger where instId = ?2 group by empId,instId)",InstLoggerEntity.class);
		theQuery.setParameter(1, empId);
		theQuery.setParameter(2, instId);
		
		@SuppressWarnings("unchecked")
		List<InstLoggerEntity> instLoggerList = (List<InstLoggerEntity>)theQuery.getResultList();
	
		if (!instLoggerList.isEmpty()) {
	
			System.out.println(instLoggerList.get(0).getInstLoggerId());

		}
		InstLoggerEntity instLogger = new InstLoggerEntity();
		instLogger.setEmpId(empId);

		instLogger.setInstId(instId);
		instLogger.setInTime(inTime);
		instLogger.setOutTime(outTime);
		save(instLogger);
		return instLoggerList;

	}

	@Override
	public List<InstLoggerEntity>  insertToTable(Calendar punchingTime, String empId, String instId) {
		// TODO Auto-generated method stub
		List<InstLoggerEntity> theInstLoggerEntityList = new ArrayList<InstLoggerEntity>();
	
		InstLoggerEntity instLoggerEntity = null;
	
	try {
//		long startTime = System.nanoTime();			

		
				
				
		//Method 1
		Query theQuery = entityManager.createNativeQuery("SELECT * from instLogger where instLoggerId = (Select MAX(instLoggerId) from instLogger where empId = ?1 and instId = ?2 GROUP BY empId,instId)",InstLoggerEntity.class);
		theQuery.setParameter(1, empId);
		theQuery.setParameter(2, instId);
		instLoggerEntity = (InstLoggerEntity) theQuery.getSingleResult();
		
		//Method 2
		//Query theQuery = entityManager.createNativeQuery("SELECT * from instLogger where empId = ?1 and instId = ?2 order by instLoggerId DESC");
		
//		theQuery.setParameter(1, empId);
//		theQuery.setParameter(2, instId);
//		theQuery.setMaxResults(1); //Use for method 2 but only if it makes good impact in complexity
//
//		System.out.println(theQuery.getResultList().get(0));
//        
//        long elapsedTime = System.nanoTime() - startTime;
//        
//        System.out.println("Total execution time to fetch result in Java in millis: "
//               + elapsedTime/1000000);

	
	if((instLoggerEntity==null)||(instLoggerEntity.getInTime() != null && instLoggerEntity.getOutTime() != null)) {//and this//if ()
		InstLoggerEntity instLogger = new InstLoggerEntity();
		instLogger.setEmpId(empId);
		instLogger.setInstId(instId);
		instLogger.setInTime(punchingTime);
		instLogger.setOutTime(null);
		save(instLogger);
		theInstLoggerEntityList.add(instLogger);
	}
	
	else if(instLoggerEntity.getOutTime()==null){
		Long instLoggerId = instLoggerEntity.getInstLoggerId();
		Query updateQuery = entityManager.createNativeQuery("UPDATE instLogger SET outTime = ?1 where instLoggerId = ?2");
		updateQuery.setParameter(1, punchingTime);
		updateQuery.setParameter(2, instLoggerId);
		updateQuery.executeUpdate();
	}
	
	//|EmptyResultDataAccessException erdae
	}catch (NoResultException nre) {
		// TODO Auto-generated catch block
		System.out.println("NoResultException");
		return null;
	}catch(DataIntegrityViolationException dive) {
		System.out.println("DataIntegrityViolationException");
		return null;
	}catch(ConstraintViolationException cve) {
		System.out.println("ConstraintViolationException");
		return null;
	}catch(Exception e) {
		System.out.println("Exception caught");
		return null;
	}
	
		return theInstLoggerEntityList;
	}

	@Override
	public List<InstLoggerEntity> fetchListFor() {
		// TODO Auto-generated method stub

		
		Query todaysList = entityManager.createNativeQuery("SELECT instLoggerId,inTime,outTime,empId,instId from instLogger where inTime >= CURDATE()\n" + 
				"  AND inTime < CURDATE() + INTERVAL 1 DAY",InstLoggerEntity.class);

//		Calendar todayInTime = Calendar.getInstance();//new GregorianCalendar();
//		// reset hour, minutes, seconds and millis
//		todayInTime.set(Calendar.HOUR_OF_DAY, 0);
//		todayInTime.set(Calendar.MINUTE, 0);
//		todayInTime.set(Calendar.SECOND, 0);
//		todayInTime.set(Calendar.MILLISECOND, 0);
//		
//		Calendar nextDayInTime = (Calendar)todayInTime.clone();
//
//		nextDayInTime.add(Calendar.DAY_OF_MONTH, 1);
//		System.out.println(todayInTime.getTime());
//		System.out.println(nextDayInTime.getTime());
//		
//		Query todaysList = entityManager.createNativeQuery("SELECT instLoggerId,inTime,outTime,empId,instId,entryStatus from instLogger where inTime BETWEEN ?1 AND ?2",InstLoggerEntity.class);
//		todaysList.setParameter(1, todayInTime);
//		todaysList.setParameter(2, nextDayInTime);
		
		@SuppressWarnings("unchecked")
		List<InstLoggerEntity> instLogger = (List<InstLoggerEntity>)todaysList.getResultList();

			      
		return instLogger;
	}

	@Override
	public List<InstLoggerEntity> fetchListFor(Calendar requestDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<InstLoggerEntity> fetchListFor(Calendar fromDate, Calendar toDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<InstLoggerEntity> unReturnedItems(Calendar requestDate) {
		// TODO Auto-generated method stub
		return null;
	}

}