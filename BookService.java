package com.greatlearning.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.library.entity.Book;
import com.greatlearning.library.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	BookRepository bookRepo;
	public Book addBook(Book b1) {
		return bookRepo.save(b1);
		
	}
	public void deleteById(int bidd) {
		bookRepo.deleteById(bidd);;
	}
	public List<Book> getBooksByAuthorName(String authorName) {
		return bookRepo.findByAuthor(authorName);
	}
	public List<Book> getBooksLessByThisId(int bidd) {
		return bookRepo.findByIdLessThan(bidd);
	}
	public Book updateBook(int bidd, Book newValues) {
		Book oldValues=bookRepo.findById(bidd).get();
		oldValues.setAuthor(newValues.getAuthor());
		oldValues.setTitle(newValues.getTitle());
		oldValues.setCategory(newValues.getCategory());
		return bookRepo.save(oldValues);
	}
	public List<Book> getAllBooks() {
		return bookRepo.findAll();
	}
	public Book getBooksById(int bidd) {
		return bookRepo.findById(bidd).get();
	}

}
