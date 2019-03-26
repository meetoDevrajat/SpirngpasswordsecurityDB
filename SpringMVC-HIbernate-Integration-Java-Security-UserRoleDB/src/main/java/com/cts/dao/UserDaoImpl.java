package com.cts.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cts.dao.UserDAO;
import com.cts.entity.User;
/*How to Save Bcrypt password--
String password = "123456";
BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
String hashedPassword = passwordEncoder.encode(password);

System.out.println(hashedPassword);
*/

@Repository
	public class UserDaoImpl implements UserDAO {

		@Autowired
		private SessionFactory sessionFactory;

		@SuppressWarnings("unchecked")
		public User findByUserName(String username) {
	
			List<User> users = new ArrayList<User>();
			users = sessionFactory.getCurrentSession()
				.createQuery("from User where username=?")
				.setParameter(0, username)
				.list();

			if (users.size() > 0) {
				return users.get(0);
			} else {
				return null;
			}

		}
}
