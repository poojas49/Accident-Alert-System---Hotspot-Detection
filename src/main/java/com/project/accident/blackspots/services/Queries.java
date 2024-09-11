package com.project.accident.blackspots.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.project.accident.blackspots.model.User;
import com.project.accident.blackspots.model.accident;
import com.project.accident.blackspots.model.location;


@Service
@Transactional
public class Queries {
	@PersistenceContext
	EntityManager em;
	
	public List<location> getLocations(String weather, String time){
		
		String sql="SELECT a FROM accident a WHERE a.weather=:weather AND a.time=:time";
		
		TypedQuery<accident> query=  em.createQuery(sql,accident.class);
		query.setParameter("weather", weather);
		query.setParameter("time", time);
		List<accident> accidents= query.getResultList();
		ModelMapper modelMapper=new ModelMapper();
		List<location> locations=accidents.stream()
				.map(accident->modelMapper.map(accident,location.class))
				.collect(Collectors.toList());
		return locations;
		
	}
	
	public List<Object> getDetailsUnsecured(String email, String password){
		String sql="SELECT u FROM User u WHERE u.email='"+email+"' AND u.pass_word='"+password+"'";
	    Query query=em.createQuery(sql, User.class);
	    List<Object> users= query.getResultList();
	    return users;
	}
	
	public List<User> getDetailsSecured(String email, String pass_word){
		String sql="SELECT u FROM User u WHERE u.email=:email AND u.pass_word=:pass_word";
	    TypedQuery<User> query=em.createQuery(sql, User.class);
	    query.setParameter("email",email);
	    query.setParameter("pass_word", pass_word);
	    List<User> users=query.getResultList();
	    return users;
	}
}
