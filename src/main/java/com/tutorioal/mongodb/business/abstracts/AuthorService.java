package com.tutorioal.mongodb.business.abstracts;

import java.util.List;

import com.tutorioal.mongodb.collections.Author;

public interface AuthorService {
	public List<Author> getAllAuthors();
	public Author createAuthor(Author author);
}
