package ca.sheridancollege.controllers;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ca.sheridancollege.beans.Account;
import ca.sheridancollege.beans.Encrypt;
import ca.sheridancollege.dao.DAO;

/**
 * Servlet implementation class AccountController
 */
@WebServlet("/AccountController")
public class AccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountController() {
        super();
        // TODO Auto-generated constructor stub
    }
	private DAO dao = new DAO();
	private Account a = new Account();
	private Encrypt e = new Encrypt();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String selectedOption = request.getParameter("menu"); //Get parameter for which option was clicked
		
		HttpSession session = request.getSession(); //Retrieve the user's session
		int accountID = (int) session.getAttribute("userID"); //Get the ID for the current logged in user
		
		//In case the user chose to add a new account to store
		String location = request.getParameter("location"); //Get the site the user is storing their password for
		String username = request.getParameter("username"); //Take the user name for that site
		String accountPassword = request.getParameter("password"); //Take the password for that site (this will be made stronger)
		
		switch(selectedOption) {
		case "Save": //Should the user choose to store a new account
			e.setRawPassword(accountPassword); //Send the password given to the encryption function
			try {
				e.process(); //Attempt to hash + salt the password for a stronger one
			} catch (NoSuchAlgorithmException e1) {	
				e1.printStackTrace();
			}
			String encPassword = e.getEncPassword(); //Retrieve the hashed + salted password
			
			
			Account newAccount = new Account(encPassword, username, location, accountID); //Create new account object to be inserted into the database
			
			dao.insertorUpdateAccount(newAccount); //Insert account into the database
			break;
		case "Delete": //Should an account entry wish to be deleted
			int deleteID = Integer.valueOf(request.getParameter("id")); //Get the ID of the account checked off
			dao.deleteAccountByID(deleteID); //Delete the account based on the ID selected
			break;
		case "Retrieve": //Placeholder for retrieve
			break;
		default:
			response.sendRedirect("Dashboard.jsp"); //Any other activities will refresh the page
			break;	
		}	
		
		//Retrieve any changes/additions to accounts after any function is done
		List<Account> retrieved = dao.displayAccount(accountID);
		request.setAttribute("retrieved", retrieved);
		request.getRequestDispatcher("Dashboard.jsp").forward(request, response);
		
		doGet(request, response);
	}

}
