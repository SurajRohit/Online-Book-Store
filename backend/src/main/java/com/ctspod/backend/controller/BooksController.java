package com.ctspod.backend.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ctspod.backend.model.Book;
import com.ctspod.backend.service.BookService;
import com.ctspod.backend.service.BookServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class BooksController {
	
	@Autowired
	private BookService cservice;         
	//private BookServiceImpl cservice;
 
	@RequestMapping("/")                    //everyone
	public String homeMessage() {
		// return "<h1>home</h1>";  
        return "home"; 
	}
	
	@RequestMapping("/user")                //admin & user   
	public String userMessage() {
		//return "<h1>user</h1>"; 
        return "accesible demo  data for user";  
	}
	
	
	@RequestMapping("/admin")              //only admin   
	public String adminMessage() {
		//return "<h1>admin</h1>";  
        return "accesible demo  data only for admin"; 
	}
	
	@GetMapping("/books")
    public List<Book> getAllBooks()  //jackson converts list to json
    {
       return cservice.getBooks();
        
    }
	
	@GetMapping("/books/{book_id}")
    public Book getBookById(@PathVariable("book_id") int _id)
    {
       return cservice.getBookWithId(_id);
        
    }
	
	@GetMapping("/getbooks/{bookIds}")
    public List<Book> getBooksByIds(@PathVariable String bookIds)
    {   List<String> ids = Arrays.asList(bookIds.split(","));
           
         return cservice.getBooksWithMultipleId(ids);
      
    }
	
	 //search by req params  eg :(/api/books/searchbytitle?title=python)
    @GetMapping("/books/searchbytitle")
	public ResponseEntity<List<Book>> getBookByTitle(@RequestParam String title) {
		return new ResponseEntity<List<Book>>(cservice.getBookWithBookName(title), HttpStatus.OK);
	}
	
	
	@PostMapping("/addbook")
    public Book addNewBook( @RequestBody Book book)
    {
		System.out.println(book);
		return cservice.addBooks(book);
        
    }
	
	@PutMapping("/updatebook/{id}")
	public Book updateBook(@RequestBody Book book, @PathVariable("id") Integer bookId)
    {
        return cservice.editBook(book, bookId);
    }
	
	
	@DeleteMapping("/delbook/{id}")
	public String delBook(@PathVariable("id") Integer bookId)
    {
		cservice.removeBook(bookId);
        return "Deleted Successfully";
    }
}
