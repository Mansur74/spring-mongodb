package com.tutorioal.mongodb.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.tutorioal.mongodb.collections.Book;

public interface BookDao extends MongoRepository<Book, String> {
	@Query("{name: ?0}")
	public List<Book> findByName(String name);
}
