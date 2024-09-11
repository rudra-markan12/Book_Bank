package com.BookProject.BookBank.dao;

import com.BookProject.BookBank.entity.Books;
import org.springframework.data.repository.CrudRepository;

import java.awt.print.Book;

public interface Bookdatabases  extends CrudRepository<Books , Integer> {

	public Books findById(int id);
}
