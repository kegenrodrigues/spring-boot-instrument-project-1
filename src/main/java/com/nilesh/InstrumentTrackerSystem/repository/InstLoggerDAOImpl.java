package com.nilesh.InstrumentTrackerSystem.repository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
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
		Query theQuery = entityManager.createNativeQuery("select instLoggerId from instLogger");
		
		@SuppressWarnings("unchecked")
		List<InstLoggerEntity> instLogger = (List<InstLoggerEntity>)theQuery.getResultList();
		return instLogger;
	}

	@Override
	public InstLoggerEntity findById(Long theInstLoggerId) {
		InstLoggerEntity instLoggerEntity = new InstLoggerEntity();

		Query theQuery = entityManager.createNativeQuery("select instLoggerId from instLogger where instLoggerId =?1");
		theQuery.setParameter(1, theInstLoggerId);

		Object dInstLoggerId = (Object)theQuery.getSingleResult();
		String result = dInstLoggerId.toString();
		instLoggerEntity.setInstId(result);
		return instLoggerEntity;
	}

	@Override
	public void save(InstLoggerEntity theInstLogger) {

		InstLoggerEntity dbInstLogger = entityManager.merge(theInstLogger);
		theInstLogger.setInstLoggerId(dbInstLogger.getInstLoggerId());
	}

	@Override
	public void deleteById(Long theInstLoggerId) {
		Query theQuery = entityManager.createNativeQuery("delete from instLogger where instLoggerId=?1");
		theQuery.setParameter(1, theInstLoggerId);
		theQuery.executeUpdate();

	}

	@Override
	public List<InstLoggerEntity>  insertToTable(Calendar punchingTime, String empId, String instId) {
		
		if(empId.isBlank()||instId.isBlank()) {
			return null;
		}
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
		
	}catch (NoResultException nre) {
		// TODO Auto-generated catch block
		System.out.println("NoResultException");
	}

	try {
		if((instLoggerEntity==null)||(instLoggerEntity.getInTime() != null && instLoggerEntity.getOutTime() != null)) {//and this//if ()
			InstLoggerEntity instLogger = new InstLoggerEntity();
			instLogger.setEmpId(empId);
			instLogger.setInstId(instId);
			instLogger.setInTime(punchingTime);
			instLogger.setOutTime(null);
			save(instLogger);//Exception can occur here
			theInstLoggerEntityList.add(instLogger);
		}
		
		else if(instLoggerEntity.getOutTime()==null){
			Long instLoggerId = instLoggerEntity.getInstLoggerId();
			Query updateQuery = entityManager.createNativeQuery("UPDATE instLogger SET outTime = ?1 where instLoggerId = ?2");
			updateQuery.setParameter(1, punchingTime);
			updateQuery.setParameter(2, instLoggerId);
			updateQuery.executeUpdate();
		}
	}catch(Exception e) {
		System.out.println("Something went wrong");
		return null;
	}
		return theInstLoggerEntityList;
	}

	@Override
	public List<InstLoggerEntity> fetchListFor() {
		
		Query todaysList = entityManager.createNativeQuery("SELECT instLoggerId,inTime,outTime,empId,instId from instLogger where inTime >= CURDATE()\n" + 
				"  AND inTime < CURDATE() + INTERVAL 1 DAY",InstLoggerEntity.class);

		@SuppressWarnings("unchecked")
		List<InstLoggerEntity> instLogger = (List<InstLoggerEntity>)todaysList.getResultList();

			      
		return instLogger;
	}

	@Override
	public List<InstLoggerEntity> unReturnedItems() {
		Query todaysList = entityManager.createNativeQuery("SELECT instLoggerId,inTime,empId,instId from instLogger where inTime >= CURDATE()\n" + 
				"  AND inTime < CURDATE() + INTERVAL 1 DAY and outTime IS NULL",InstLoggerEntity.class);

		@SuppressWarnings("unchecked")
		List<InstLoggerEntity> instLogger = (List<InstLoggerEntity>)todaysList.getResultList();
	      
		return instLogger;
	}

}