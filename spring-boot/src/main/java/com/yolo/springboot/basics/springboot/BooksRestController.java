package com.yolo.springboot.basics.springboot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api")
public class BooksRestController {
	
	static List<Book> books;
	static
	{
		books = new ArrayList<>();
		books.add(new Book(1, "book1", "auther1"));
		books.add(new Book(2, "book2", "auther2"));
		books.add(new Book(3, "book3", "auther3"));
	}
	
	@GetMapping("/getBooks")
	public List<Book> getAllBooks()
	{
		books.add(new Book(5, "book5", "auther5"));
		System.out.println("http Get[/books] request received!");
		return books;
	}
	
	@GetMapping("/getBook")
	public ResponseEntity<Book> getBook(@RequestParam long id)
	{
		Book book = null;
		for(Book tempBook : books)
		{
			if(tempBook.getId() == id)
			{
				return new ResponseEntity<Book>(tempBook, HttpStatus.OK);
			}
		}
		return new ResponseEntity<Book>(book, HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/addBook")
	public Book addBook(@RequestBody Book book)
	{
		books.add(book);
		return book;
	}
	
	@PutMapping("/updateBook")
	public ResponseEntity<Book> updateBook(@RequestBody Book book)
	{
		for(Book tempBook : books)
		{
			if(tempBook.getId() == book.getId())
			{
				tempBook.setAuthor(book.getAuthor());
				tempBook.setName(book.getName());
				return new ResponseEntity<>(tempBook, HttpStatus.CREATED);
			}
		}
		return new ResponseEntity<Book>(book, HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/deleteBook")
	public ResponseEntity<String> deleteBook(@RequestParam long id)
	{
		for(Book tempBook : books)
		{
			if(tempBook.getId() == id)
			{
				books.remove(tempBook);
				return new ResponseEntity<String>("Book with id "+ id + " has been deleted!!", HttpStatus.ACCEPTED);
			}
		}
		return new ResponseEntity<String>("Book with id "+ id + " not found!!", HttpStatus.NOT_FOUND);
	}

}
