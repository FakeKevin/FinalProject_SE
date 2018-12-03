package ca.sheridancollege.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ca.sheridancollege.beans.Account;
import ca.sheridancollege.beans.User;

public class DAO {

	SessionFactory sessionFactory = new Configuration()
			.configure("ca/sheridancollege/config/hibernate.cfg.xml")
			.buildSessionFactory();
	//For creating users in the database
	public void insertorUpdateUser(User user) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(user);

		session.getTransaction().commit();
		session.close();
	}
	//This method deletes users by the selected id
	public void deleteUserById(int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		User toDelete = session.get(User.class, id);
		session.delete(toDelete);
		
		session.getTransaction().commit();
		session.close();
	}
	//this method creates an account for the user
	public void insertorUpdateAccount(Account account) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(account);

		session.getTransaction().commit();
		session.close();
		
	}
	//This method deletes the account of a user by the Id
	public void deleteAccountByPass(String password) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Account toDelete = session.get(Account.class, password);
		session.delete(toDelete);
		
		session.getTransaction().commit();
		session.close();
	}
	//This method verifies the users credentials before logging in
	public List<User> queryUser(String email, String password) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Query query = session.getNamedQuery("User.login");
		
		query.setParameter("username", email);
		query.setParameter("password", password);
		
		List<User> userList = query.getResultList();
		session.getTransaction().commit();
		session.close();
		return userList;
	}
	public List<Account> displayAccount(){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query query = session.getNamedQuery("Account.display");
		List<Account> accountList = query.getResultList();
		session.getTransaction().commit();
		session.close();
		return accountList;
	}
}

