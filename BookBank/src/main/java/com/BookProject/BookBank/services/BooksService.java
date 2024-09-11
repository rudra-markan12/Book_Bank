package com.BookProject.BookBank.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BookProject.BookBank.dao.Bookdatabases;
import com.BookProject.BookBank.entity.Books;

@Service
public class BooksService {

	@Autowired
	Bookdatabases bookdatabases;
//	private static  List<Books> list = new ArrayList<>();
//	static{
//	 list.add(new Books(1 , "R" , "Rudra"));
//	 list.add(new Books(2 , "R" , "Rudra"));
//	}

	public List<Books> getBooks(){
		List<Books> list = (List<Books>)  this.bookdatabases.findAll();
        return list;
	}
//	 public List<Books> getBooks(){
//		return list;
//	}

	public Books getbookId(int id){
//		Books book = null;
//		book = list.stream().filter(e->e.getId()== id).findFirst().get();
//
//		return book;
	 Books book = 	this.bookdatabases.findById(id);
	 return book;
	}
	public Books addBook(Books book){
	Books  b = 	this.bookdatabases.save(book);
	return b;
	}

	public void  deleteBook(int id){
		this.bookdatabases.deleteById(id);
		return;
	}


//	public boolean isPresent(int bookid){
//		for(Books book : list){
//			Books ispresent  = null;
//			if(book.getId()==bookid){
//				ispresent = book;
//				break;
//			}
//			if (ispresent != null)
//				list.remove(ispresent);
//				return true;
//		}
//		return false;
//	}

	public void  updateBook(Books book , int id){
//		for(Books books : list){
//			if(books.getId() == id)
//			{
//				books.setId(book.getId());
//				books.setTitle(book.getTitle());
//				books.setAuthor(book.getAuthor());
//				return true;
//			}
//		}
//		return false;
		book.setId(id);
		this.bookdatabases.save(book);
	}
}
