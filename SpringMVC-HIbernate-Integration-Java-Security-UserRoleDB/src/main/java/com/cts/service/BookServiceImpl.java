package com.cts.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.dao.BookDAO;
//import com.cts.dao.BookDAO;
import com.cts.entity.Book;
@Service("bookService")
public class BookServiceImpl implements BookService{

	
	@Autowired
	private BookDAO bookDAO;
	@Override
	@Transactional
	public void saveBook(Book book) {
		System.out.println(" Save from service");
		bookDAO.saveBook(book);	
	}

	@Override
	@org.springframework.transaction.annotation.Transactional
	public List<Book> listAllBooks() {
		System.out.println(" I am in list service");
		return bookDAO.listBooks();
		
	}
		 @Override
		    @Transactional
		    public Book getBook(int theId) {
		        return bookDAO.getBook(theId);
		    }
		 @Override
		    @Transactional
		    public void deleteBook(int theId) {
		        bookDAO.deleteBook(theId);
		    }
}
