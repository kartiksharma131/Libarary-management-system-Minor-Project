package com.minorProject.LibrarymanagementsystemminorProject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.minorProject.LibrarymanagementsystemminorProject.Models.Author;

public interface AuthorRepo extends JpaRepository<Author, Integer> {

	//jpql query -- preferred
	//with jpql we can't use *
	//@Query(value="select a from Author a where a.email=:emailParam")
	//@Query(value="select a from Author a where a.email = ?1")   //this is another valid example which means map with first argument of method
	//Author findAuthor(String emailParam);
	
	//native query
	//@Query(value="select * from Author where email = :emailParam",nativeQuery = true)
	@Query(value="select * from Author where email = ?1",nativeQuery = true)
	Author findAuthor(String emailParam);
	/*
	 * two ways of writing custom query
	 * 1) JPQL - java persistance query lang
	 * above query will executes considering java class or object
	 * 2) NATIVE Query
	 * format executes considering your sql tables
	 */
	
	//jpql query

}
