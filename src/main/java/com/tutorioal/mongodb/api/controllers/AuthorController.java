package com.tutorioal.mongodb.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorioal.mongodb.business.abstracts.AuthorService;
import com.tutorioal.mongodb.collections.Author;

@RestController
@RequestMapping("/api")
public class AuthorController {
	
	@Autowired
	AuthorService authorService;
	
	@GetMapping("/author")
	public ResponseEntity<List<Author>> getAllBooks()
	{
		List<Author> author = authorService.getAllAuthors();
		return ResponseEntity.status(HttpStatus.OK).body(author);
	}
	
	@PostMapping("/author")
	public ResponseEntity<Author> createBook(@RequestBody Author author)
	{
		Author createdAuthor = authorService.createAuthor(author);
		return ResponseEntity.status(HttpStatus.OK).body(createdAuthor);
	}
	

}
