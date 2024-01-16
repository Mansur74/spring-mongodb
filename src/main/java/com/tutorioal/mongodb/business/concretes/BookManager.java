package com.tutorioal.mongodb.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutorioal.mongodb.business.abstracts.BookService;
import com.tutorioal.mongodb.collections.Author;
import com.tutorioal.mongodb.collections.Book;
import com.tutorioal.mongodb.dataAccess.abstracts.AuthorDao;
import com.tutorioal.mongodb.dataAccess.abstracts.BookDao;

@Service
public class BookManager implements BookService {
	
	@Autowired
	private BookDao bookDao;
	
	@Autowired
	private AuthorDao authorDao;

	@Override
	public List<Book> getAllBooks() {
		List<Book> books = bookDao.findAll();
		return books;
	}
	
	@Override
	public List<Book> getBooksByName(String name)
	{
		List<Book> book = bookDao.findByName(name);
		return book;
	}

	@Override
	public Book createBook(Book book, String authorId) {
		 Book savedBook = bookDao.save(book); 
		 Author author = authorDao.findById(authorId).orElseThrow(() -> new IllegalArgumentException("Author not found with ID: " + authorId));
	     author.getBooks().add(book);
	     authorDao.save(author);
	     return savedBook;
	}

}
