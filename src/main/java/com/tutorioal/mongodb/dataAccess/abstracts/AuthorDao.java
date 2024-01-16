package com.tutorioal.mongodb.dataAccess.abstracts;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tutorioal.mongodb.collections.Author;

public interface AuthorDao extends MongoRepository<Author, String> {

}
