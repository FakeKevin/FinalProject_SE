package ca.sheridancollege.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ca.sheridancollege.beans.Person;

public class DAO {

	SessionFactory sessionFactory = new Configuration()
			.configure("ca/sheridancollege/config/hibernate.cfg.xml")
			.buildSessionFactory();

	public void insertPerson(Person person) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(person);

		session.getTransaction().commit();
		session.close();
	}

}
