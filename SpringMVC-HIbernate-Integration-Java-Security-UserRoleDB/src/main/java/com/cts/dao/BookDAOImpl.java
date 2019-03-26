package com.cts.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.cts.entity.Book;
@Repository("bookDAO")
public class BookDAOImpl  implements BookDAO{

	   @Autowired
	   private SessionFactory sessionFactory;
	   @Autowired
	   private PasswordEncoder passwordEncoder;
	@Override
	public void saveBook(Book book) {
		//sessionFactory.getCurrentSession().save(book);
		//BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		//-----------------Encrypt Password------------------
		System.out.println("Before Encryption"+book.getPassword());
		book.setPassword(passwordEncoder.encode(book.getPassword()));
		System.out.println("After Encryption"+book.getPassword());
		//----------------------------

		
		sessionFactory.getCurrentSession().saveOrUpdate(book);
		System.out.println(" Data Saved");
	}

	@Override
	public List<Book> listBooks() {
	System.out.println(" Hello" +sessionFactory);
	System.out.println(" From dao list");
		 Session session = sessionFactory.getCurrentSession();
	        CriteriaBuilder cb = session.getCriteriaBuilder();
	        CriteriaQuery< Book > cq = cb.createQuery(Book.class);
	        Root<Book > root = cq.from(Book.class);
	        cq.select(root);
	        Query query = session.createQuery(cq);
	        return query.getResultList();
	}
	 @Override
	    public Book getBook(int theId) {
	        Session currentSession = sessionFactory.getCurrentSession();
	        Book theBook = currentSession.get(Book.class, theId);
	        return theBook;
	    }
	 
	 @Override
	    public void deleteBook(int id) {
	        Session session = sessionFactory.getCurrentSession();
	        Book book = session.byId(Book.class).load(id);
	        session.delete(book);
	    }
}
