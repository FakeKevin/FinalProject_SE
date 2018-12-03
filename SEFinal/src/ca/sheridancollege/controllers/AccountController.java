package ca.sheridancollege.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		String location = request.getParameter("location");
		String username = request.getParameter("username");
		String Accountpassword = request.getParameter("password");		
		
		e.setRawPassword(Accountpassword);
		e.process();
		
		String encPassword = e.getEncPassword();
		
		doGet(request, response);
	}

}
