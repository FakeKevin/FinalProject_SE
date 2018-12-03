package ca.sheridancollege.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String loginPassword = request.getParameter("password");
		
		User user = new User(firstname,lastname,email,loginPassword);
		List<User> verifyLogin = dao.verifyUser(email);
		boolean verified = u.login(verifyLogin);
		if(verified == false) {
			dao.insertorUpdateUser(user);
			response.sendRedirect("Index.html");
			
		}
		else {
			response.sendRedirect("UserCreate.html");
			//Create error message about account already existing 	
		}
		doGet(request, response);
	}

}
