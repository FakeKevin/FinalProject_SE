package ca.sheridancollege.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ca.sheridancollege.beans.User;
import ca.sheridancollege.dao.DAO;

/**
 * Servlet implementation class NewUserController
 */
@WebServlet("/NewUserController")
public class NewUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewUserController() {
        super();
        // TODO Auto-generated constructor stub
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
		//Creates a new session
		HttpSession session = request.getSession();
		//Retrieve parameters from html and jsp pages
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String loginPassword = request.getParameter("password");
		//Create new User object with parameter retrieved 
		User user = new User(firstname,lastname,email,loginPassword);
		/*Create an arraylist with the row retrieved from the verify user method in the DAO
		and verify email when creating users. If the verify login method returns false, then no account is registered and the
		create user method can be executed.*/
		List<User> verifyLogin = dao.verifyUser(email);
		boolean verified = u.login(verifyLogin);
		if(verified == false) {
			//create user in database
			dao.insertorUpdateUser(user);
			//pass userid attribute to jsp
			session.setAttribute("userID", user.getId());
			response.sendRedirect("Dashboard.jsp");
			
		}
		else {
			//User is sent back to the create user page upon an already existing user. 
			response.sendRedirect("UserCreate.html");
				
		}
		doGet(request, response);
	}

}
