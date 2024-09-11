package com.project.accident.blackspots.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.project.accident.blackspots.model.User;
import com.project.accident.blackspots.model.accident;

@Repository
public interface AccidentRepository extends JpaRepository<accident, Long>{
//	List<location> findAllLocations(@Param(value="weather") String weather, @Param(value="time") String time);

//	List<accident> findAllByWeatherAndTime(String weather, String time);
	
	@PersistenceContext
	static EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return null;
	}
}


