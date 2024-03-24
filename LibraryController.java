package com.greatlearning.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.library.entity.Book;
import com.greatlearning.library.service.BookService;
//localhost:8085/books/getBookPredefinedObject
@Controller
@RequestMapping("/books")
public class LibraryController {
	
	@Autowired
	BookService bookService;
	
//	@GetMapping("/")
//	public String greet()
//	{
//		return "Welcome to my Library";
//	}
//	
//	
//	@GetMapping("/getBookPredefinedObject")
//	public Book getBookPredefinedObject()
//	{
//		Book b1=new Book();
//		b1.setId(1);
//		b1.setTitle("Let Us C");
//		b1.setAuthor("Yashwant Kanetkar");
//		b1.setCategory("Programming");
//		return b1;
//	}
//	
//	@PostMapping("/addPredefinedBookObjectReturningString")
//	public String addPredefinedBookObjectReturningString()
//	{
//		Book b1=new Book();
//		b1.setId(1);
//		b1.setTitle("Let Us C");
//		b1.setAuthor("Yashwant Kanetkar");
//		b1.setCategory("Programming");
//		bookService.addBook(b1);
//		return "Book Added Successfully";
//	}
//	
//	
//	@PostMapping("/addPredefinedBookObjectReturningObject")
//	public Book addPredefinedBookObjectReturningObject()
//	{
//		Book b1=new Book();
//		//b1.setId(1);
//		b1.setTitle("Let Us C");
//		b1.setAuthor("Yashwant Kanetkar");
//		b1.setCategory("Programming");
//		return bookService.addBook(b1); 
//	}
//	
//	@PostMapping("/addBookByPostmanKeyValue")
//	public Book addBookByPostmanKeyValue(
//	@RequestParam("a") String authorName,
//	@RequestParam("b") String bookTitle,
//	@RequestParam("c") String category)
//	{
//	Book b1=new Book();
//	b1.setAuthor(authorName);
//	b1.setTitle(bookTitle);
//	b1.setCategory(category);
//	return bookService.addBook(b1);
//	}
//	
//	@PostMapping("/addBookByPostmanObjectBody")
//	public Book addBookByPostmanObjectBody(
//	@RequestBody Book b1)
//	{
//	return bookService.addBook(b1);
//	}
//	///addBookByPostmanPathVariable/Sanjeev Kapoor/{Biryani Dishes}/{Cooking}
//	@PostMapping("/addBookByPostmanPathVariable/{a}/{b}/{c}")
//	public Book addBookByPostmanPathVariable(
//	@PathVariable("a") String authorName,
//	@PathVariable("b") String bookTitle,
//	@PathVariable("c") String category)
//	{
//	Book b1=new Book();
//	b1.setAuthor(authorName);
//	b1.setTitle(bookTitle);
//	b1.setCategory(category);
//	return bookService.addBook(b1);
//	}
//	
//	@DeleteMapping("/deleteBookByIdUsingRequestParam")
//	String deleteBookById(@RequestParam("bid") int bidd)
//	{
//		bookService.deleteById(bidd);
//		return "Book deleted Successfully";
//	}
//	
//	@GetMapping("/getBooksByAuthorName")
//	List<Book> getBooksByAuthorName(@RequestParam("aname") String authorName)
//	{
//		return bookService.getBooksByAuthorName(authorName);
//	}
//	
//
//	@GetMapping("/getBooksLessByThisId")
//	List<Book> getBooksLessByThisId(@RequestParam("bid") int bidd)
//	{
//		return bookService.getBooksLessByThisId(bidd);
//	}
//	
//	@PutMapping("/updateBook")
//	Book updateBook(@RequestParam("bid") int bidd,
//					@RequestBody Book newValues)
//	{
//		return bookService.updateBook(bidd,newValues);
//	}
//	
//	@GetMapping("/getAllBooks")
//	List<Book> getAllBooks(Model bm)
//	{
//		List<Book> allbooks= bookService.getAllBooks();
//		bm.addAttribute("books",allbooks);
//		return "book-list";
//	}
	
	
	@GetMapping("/list")
	String getAllBooks(Model bm)
	{
		List<Book> allbooks= bookService.getAllBooks();
		bm.addAttribute("books",allbooks);
		return "books/list-books";
	}
	
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel)
	{
		Book b1=new Book();
		theModel.addAttribute("book",b1);
		return "books/book-form";
	}
	
	
	@PostMapping("/save")
	public String addBookByPostmanObjectBody(
	@ModelAttribute("book") Book b1)
	{
	bookService.addBook(b1);
	return "redirect:/books/list";
	}
	
	@PostMapping("/delete")
	String deleteBookById(@RequestParam("bookId") int bidd)
	{
		bookService.deleteById(bidd);
		return "redirect:/books/list";
	}
	
	
	@PostMapping("/showFormForUpdate")
	String updateBook(@RequestParam("bookId") int bidd,
					Model theModel)
	{
		Book dbbook=bookService.getBooksById(bidd);
		theModel.addAttribute("book",dbbook);
		return "books/book-form";
	}
}
