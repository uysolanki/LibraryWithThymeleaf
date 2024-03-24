package com.greatlearning.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.library.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

	public List<Book> findByAuthor(String aname);
	
	public List<Book> findByIdLessThan(int id);
}
