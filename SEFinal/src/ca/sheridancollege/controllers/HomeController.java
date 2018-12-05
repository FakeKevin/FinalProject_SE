package ca.sheridancollege.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.persistence.Query;

import ca.sheridancollege.beans.Account;
import ca.sheridancollege.beans.User;
import ca.sheridancollege.dao.DAO;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 102831973239L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
    }
	private DAO dao = new DAO();
	private User u = new User();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String email = request.getParameter("email"); //Get email entered
		String loginPassword = request.getParameter("password"); //Get password entered
		HttpSession session = request.getSession(); //Create a session for this user
		
		User user = new User(email, loginPassword); //Create a user object for the current login
		
		List<User> verifyLogin = dao.queryUser(email, loginPassword);
		boolean chkLogin = u.login(verifyLogin);
		if(chkLogin == true) {
			session.setAttribute("userID", verifyLogin.get(0).getId()); //This is a session for the current login
			session.setAttribute("failedLog", ""); //Update the failed login message to be blank (since the login was successful)
			response.sendRedirect("Dashboard.jsp"); //Redirect the user to their dash board
		}
		else {
			session.setAttribute("failedLog", "Login failed. Please try again."); //Enable the login failed message
			response.sendRedirect("form.jsp"); //Send users back to the same page to try again
			
		}
		
		doGet(request, response);
	}

}
