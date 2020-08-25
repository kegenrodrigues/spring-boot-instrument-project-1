package com.nilesh.InstrumentTrackerSystem.repository;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nilesh.InstrumentTrackerSystem.entity.EmployeeEntity;
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
	public List<InstLoggerEntity> findAll(Calendar startTime, Calendar inTime, Calendar timeNow, String empId, String instId) {
		// TODO Auto-generated method stub
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