package com.tutorioal.mongodb.collections;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "authors")
public class Author {
	@Id
	private String id;
	private String firstName;
	private String lastName;
	private int age;
	@DBRef
	private List<Book> books = new ArrayList<>();
}
