package com.BookProject.BookBank.controllers;
import com.BookProject.BookBank.entity.Books;
import com.BookProject.BookBank.services.BooksService;

import org.apache.tomcat.util.http.parser.HttpParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

//@Controller
@RestController  // when we use restcontroller then there is no req of the @ResponseBody

public class BookControllers {

    @Autowired
	BooksService booksService;
//	@RequestMapping(value = "/books" , method = RequestMethod.GET)
	@GetMapping(  value = "/book")
	public ResponseEntity<List<Books>> getAllBooks() {
		List<Books> list = this.booksService.getBooks();

		if(list.isEmpty()){
			return ResponseEntity.notFound().build();
		}
		else{
		return ResponseEntity.status(HttpStatus.OK).body(list);
		}
	}
	@ResponseBody
	public List<Books> getValues(){

        return  booksService.getBooks();
	}
//   -------------------------------------------------------------------------------------------
	@GetMapping("/book/{id}")


	public ResponseEntity<Books> getBookById(@PathVariable int id) {
	 Books book = this.booksService.getbookId(id);
	 if (book == null) {
		 return ResponseEntity.notFound().build();
	 }
	 else{
		 	return ResponseEntity.ok(book);
	 }
	}


//	public Books getbOOKS(@PathVariable("id")  int id){
//
//		return this.booksService.getbookId(1);
//	}






	@PostMapping("/book")
	public ResponseEntity<Books>  addBook(@RequestBody Books book){
		Books bo =  null;
		try {
			bo = this.booksService.addBook(book);
			return ResponseEntity.ok(bo);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}


	}

	@DeleteMapping("/book/{bookid}")

	public ResponseEntity<Void> deleteBook(@PathVariable("bookid") int bookid){
		try {
			this.booksService.deleteBook(bookid);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PutMapping("/book/{updateid}")

	public ResponseEntity<Void> updateBook(@RequestBody Books updatebook, @PathVariable("updateid")  int id){
		try {
			this.booksService.updateBook(updatebook, id);
			return ResponseEntity.status(HttpStatus.UPGRADE_REQUIRED).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}