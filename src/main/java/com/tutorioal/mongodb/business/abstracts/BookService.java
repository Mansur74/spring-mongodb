package com.tutorioal.mongodb.business.abstracts;

import java.util.List;

import com.tutorioal.mongodb.collections.Book;

public interface BookService {
	public List<Book> getAllBooks();
	public List<Book> getBooksByName(String name);
	public Book createBook(Book book, String authorId);
}
