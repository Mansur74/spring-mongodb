package com.tutorioal.mongodb.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutorioal.mongodb.business.abstracts.AuthorService;
import com.tutorioal.mongodb.collections.Author;
import com.tutorioal.mongodb.dataAccess.abstracts.AuthorDao;

@Service
public class AuthorManager implements AuthorService{
	
	@Autowired
	private AuthorDao authorDao;

	@Override
	public List<Author> getAllAuthors() {
		List<Author> authors = authorDao.findAll();
		return authors;
	}

	@Override
	public Author createAuthor(Author author) {
		Author createdAuthor = authorDao.save(author);
		return createdAuthor;
	}

}
