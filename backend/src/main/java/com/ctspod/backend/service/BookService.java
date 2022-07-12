package com.ctspod.backend.service;

import java.util.List;

import com.ctspod.backend.model.Book;

public interface BookService {
  
	public List<Book> getBooks();
	 
	 public Book addBooks(Book b);
	 
	 public Book getBookWithId(int id);
	 
	 public List<Book> getBooksWithMultipleId(List<String> ids);
	 
	 public List<Book> getBookWithBookName(String bookname);
	 
	 
	 
	 public Book editBook( Book book,  Integer bookId);
	 
	 public void removeBook(Integer bookId);
}
