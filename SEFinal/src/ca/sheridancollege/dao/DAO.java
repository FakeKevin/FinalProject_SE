package ca.sheridancollege.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ca.sheridancollege.beans.Account;
import ca.sheridancollege.beans.User;

public class DAO {
	//Creates a hibernate session using config files 
	SessionFactory sessionFactory = new Configuration().configure("ca/sheridancollege/config/hibernate.cfg.xml")
			.buildSessionFactory();

	// For creating users in the database
	public void insertorUpdateUser(User user) {
		//create session
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		//saves user 
		session.save(user);
		//commit and close 
		session.getTransaction().commit();
		session.close();
	}

	// This method deletes users by the selected id
	public void deleteUserById(int id) {
		//create session
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		//Deletes user that has id parameter specified 
		User toDelete = session.get(User.class, id);
		session.delete(toDelete);
		//commit and close
		session.getTransaction().commit();
		session.close();
	}

	// this method creates an account for the user
	public void insertorUpdateAccount(Account account) {
		//create session
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		//Create account in database
		session.saveOrUpdate(account);
		//commit and close
		session.getTransaction().commit();
		session.close();

	}

	// This method deletes the account of a user by the Id
	public void deleteAccountByID(int accountID) {
		//create session
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		//delete specific account with accoundid specified
		Account toDelete = session.get(Account.class, accountID);
		session.delete(toDelete);
		//commit and close
		session.getTransaction().commit();
		session.close();
	}

	// This method verifies if a user exists upon creation
	public List<User> verifyUser(String email) {
		//create session
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		//Use query specified in User bean class
		Query query = session.getNamedQuery("User.exists");
		//get parameter and set database parameter to email
		query.setParameter("email", email);
		//Save results to arraylist 
		List<User> user = query.getResultList();
		//commit and close
		session.getTransaction().commit();
		session.close();

		return user;

	}

	// This method verifies the users credentials before logging in
	public List<User> queryUser(String email, String password) {
		//create session
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		//Create query using user.login named parameter in User bean class
		Query query = session.getNamedQuery("User.login");
		//set database parameters using passed parameters 
		query.setParameter("email", email);
		query.setParameter("password", password);
		//Save results to arraylist 
		List<User> userList = query.getResultList();
		//commit and close
		session.getTransaction().commit();
		session.close();
		return userList;
	}
	//This method displays all results with the corresponding accountID
	public List<Account> displayAccount(int accountid) {
		//create session
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		//Create query using account.display named parameter in Account bean class
		Query query = session.getNamedQuery("Account.display");
		//set database parameters using passed parameters
		query.setParameter("accountid", accountid);
		//Save results to arraylist 	
		List<Account> accountList = query.getResultList();
		//commit and close
		session.getTransaction().commit();
		session.close();
		return accountList;
	}
}
