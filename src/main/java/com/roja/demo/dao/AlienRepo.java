package com.roja.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
//import java.util.List;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
import com.roja.demo.model.Alien;


//public interface AlienRepo extends CrudRepository<Alien, Integer> 
public interface AlienRepo extends JpaRepository<Alien, Integer> 
{
	/*List<Alien> findByTech(String tech);

	List<Alien> findByAidGreaterThan(int aid);

	@Query("from Alien where tech=?1 order by aname")
	List<Alien> findebySorted(String string);*/
}
