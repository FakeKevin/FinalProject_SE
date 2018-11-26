package ca.sheridancollege.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ca.sheridancollege.beans.User;

public class DAO {

	SessionFactory sessionFactory = new Configuration()
			.configure("ca/sheridancollege/config/hibernate.cfg.xml")
			.buildSessionFactory();

	public void insertUser(User user) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(user);

		session.getTransaction().commit();
		session.close();
	}
	public void deleteUserById(int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		User toDelete = session.get(User.class, id);
		session.delete(toDelete);
		
		session.getTransaction().commit();
		session.close();
	}
}
