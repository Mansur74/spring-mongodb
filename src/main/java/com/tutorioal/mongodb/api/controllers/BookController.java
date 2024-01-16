package com.tutorioal.mongodb.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tutorioal.mongodb.business.abstracts.BookService;
import com.tutorioal.mongodb.collections.Book;

@RestController
@RequestMapping("/api")
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping("/book")
	public ResponseEntity<List<Book>> getAllBooks()
	{
		List<Book> books = bookService.getAllBooks();
		return ResponseEntity.status(HttpStatus.OK).body(books);
	}
	
	@GetMapping("/book/{name}")
	public ResponseEntity<List<Book>> getBookByName(@PathVariable String name)
	{
		List<Book> book = bookService.getBooksByName(name);
		return ResponseEntity.status(HttpStatus.OK).body(book);
	}
	
	@PostMapping("/author/{authorId}/book")
	public ResponseEntity<Book> createBook(@RequestBody Book book, @PathVariable String authorId)
	{
		Book createdBook = bookService.createBook(book, authorId);
		return ResponseEntity.status(HttpStatus.OK).body(createdBook);
	}
}
