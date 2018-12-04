package ca.sheridancollege.controllers;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

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
		
		String selectedOption = request.getParameter("menu");
		
		HttpSession session = request.getSession();
		int accountID = (int) session.getAttribute("userID"); //Get the ID for the current logged in user
		
		String location = request.getParameter("location");
		String username = request.getParameter("username");
		String accountPassword = request.getParameter("password");
		
		switch(selectedOption) {
		case "Save":
			e.setRawPassword(accountPassword);
			try {
				e.process();
			} catch (NoSuchAlgorithmException e1) {	
				e1.printStackTrace();
			}
			String encPassword = e.getEncPassword();
			
			Account newAccount = new Account(accountID, location, username, encPassword);
			
			dao.insertorUpdateAccount(newAccount);
			break;
		case "Delete":
			int deleteID = Integer.valueOf(request.getParameter("sequence"));
			dao.deleteAccountByID(deleteID);
			break;
		case "Retrieve":
			List<Account> retrieved = dao.displayAccount();
			request.setAttribute("retrieved", retrieved);
			response.sendRedirect("Dashboard.jsp");
			break;
		default:
			response.sendRedirect("Dashboard.jsp");
			break;	
		}	
		
		
		//FOR SAVING
		
		
		
		
		doGet(request, response);
	}

}
