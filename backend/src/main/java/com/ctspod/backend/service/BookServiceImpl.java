package com.ctspod.backend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctspod.backend.model.Book;
import com.ctspod.backend.repo.BookDao;

@Service
public class BookServiceImpl implements BookService {
 
	@Autowired
	private BookDao dao;
	
	public List<Book> getBooks() {
		
		return dao.findAll();
	}

	
	public Book addBooks(Book b) {
		
		 dao.save(b);
		 return b;
	}

	
	public Book getBookWithId(int id) {
		
		return dao.findById(id).get();
	}
	
    public List<Book> getBooksWithMultipleId(List<String>ids) {
    	List<Book>ans = new ArrayList<Book>();
    	
    	for(String z: ids) {
    		int t= Integer.parseInt(z);
    		ans.add(dao.findById(t).get());
    	}
		
		return ans;
	}

	
	public List<Book> getBookWithBookName(String bookname) {
		
		return dao.findByTitle(bookname);
	}

	
	public Book editBook(Book book, Integer bookId) {
		
		Book bookDB= dao.findById(bookId).get();  //book obj fetched from DB which is selected for updating

	     if (Objects.nonNull(book.getTitle()) && !"".equalsIgnoreCase(book.getTitle())) {
	    	 bookDB.setTitle(book.getTitle());
	     }

	     if (Objects.nonNull(book.getAuthor()) && !"".equalsIgnoreCase(book.getAuthor())) {
	    	 bookDB.setAuthor(book.getAuthor());
	     }

	     if (book.getPrice() != bookDB.getPrice()) {
	    	 bookDB.setPrice(book.getPrice());
	     }

	     return dao.save(bookDB);
	}

	
	public void removeBook(Integer bookId) {
		
		dao.deleteById(bookId);
	}

}
