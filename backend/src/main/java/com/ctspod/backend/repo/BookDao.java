package com.ctspod.backend.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ctspod.backend.model.Book;

@Repository
public interface BookDao extends JpaRepository<Book, Integer> {
 
 
	
	List<Book> findByTitle(String coursename);
       
}
