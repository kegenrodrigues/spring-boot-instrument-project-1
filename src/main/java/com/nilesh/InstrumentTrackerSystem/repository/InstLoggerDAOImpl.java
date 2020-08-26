package com.nilesh.InstrumentTrackerSystem.repository;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
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
		//return null;
	}

	@Override
	public List<InstLoggerEntity> findByPair(Calendar startTime, Calendar inTime, Calendar outTime, Calendar timeNow, String empId, String instId) {
		// TODO Auto-generated method stub
		Boolean entryStatus = true;
		Query theQuery = entityManager.createNativeQuery("SELECT * from instLogger where empId = ?1 and instId = ?2 and outTime = (Select Max(outTime) from instLogger where instId = ?2 group by empId,instId)",InstLoggerEntity.class);
		theQuery.setParameter(1, empId);
		theQuery.setParameter(2, instId);
		
		@SuppressWarnings("unchecked")
		List<InstLoggerEntity> instLoggerList = (List<InstLoggerEntity>)theQuery.getResultList();
	
		if (!instLoggerList.isEmpty()) {
	
			System.out.println(instLoggerList.get(0).getInstLoggerId());
			System.out.println("*******"+instLoggerList.get(0).getEntryStatus());
			if(instLoggerList.get(0).getEntryStatus()) {
				System.out.println("in false if condition");
				entryStatus = false;
			}
		}
		InstLoggerEntity instLogger = new InstLoggerEntity();
		instLogger.setEmpId(empId);
		instLogger.setEntryStatus(entryStatus);
		instLogger.setInstId(instId);
		instLogger.setInTime(inTime);
		instLogger.setOutTime(outTime);
		save(instLogger);
		return instLoggerList;

	}

	@Override
	public List<InstLoggerEntity> insertToTable(Calendar punchingTime, String empId, String instId) {
		// TODO Auto-generated method stub

//		long startTime = System.nanoTime();
		
		//Method 1
		Query theQuery = entityManager.createNativeQuery("SELECT * from instLogger where instLoggerId = (Select MAX(instLoggerId) from instLogger where empId = ?1 and instId = ?2 GROUP BY empId,instId)",InstLoggerEntity.class);
		theQuery.setParameter(1, empId);
		theQuery.setParameter(2, instId);
		System.out.println("**"+theQuery.getSingleResult()); 
		
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


		
	
		
//		@SuppressWarnings("unchecked")
//		List<InstLoggerEntity> instLoggerList = (List<InstLoggerEntity>)theQuery.getResultList();
//	
//		if (!instLoggerList.isEmpty()) {
//	
//			System.out.println(instLoggerList.get(0).getInstLoggerId());
//			System.out.println("*******"+instLoggerList.get(0).getEntryStatus());
//			if(instLoggerList.get(0).getEntryStatus()) {
//				System.out.println("in false if condition");
//				entryStatus = false;
//			}
//		}
//		InstLoggerEntity instLogger = new InstLoggerEntity();
//		instLogger.setEmpId(empId);
//		instLogger.setEntryStatus(entryStatus);
//		instLogger.setInstId(instId);
//		instLogger.setInTime(inTime);
//		instLogger.setOutTime(outTime);
//		save(instLogger);
//		return instLoggerList;
//		
		
		return null;
	}
	
	

}


//public List<MovieObject> getMovieByTitle(EntityManager entityManager,String title) {
//
//    String queryStr = "SELECT movieId, title, genres FROM movies where title like = ?1";
//    try {
//        Query query = entityManager.createNativeQuery(queryStr);
//        query.setParameter(1, title);
//
//        List<Object[]> objectList = query.getResultList();
//
//        List<MovieObject> result = new ArrayList<>();
//        for (Object[] row : objectList) {
//            result.add(new MovieObject(row));
//        }
//        return result;
//    } catch (Exception e) {
//        e.printStackTrace();
//        throw e;
//    }
//}