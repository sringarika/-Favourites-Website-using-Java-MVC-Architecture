/**
 * @author sringarikapandey
 * @date Dec 14
 * @course 08-672 A2 J2EE
 */
package com.sring.hw4.controller;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringEscapeUtils;

import com.sring.hw4.model.UserBean;
import com.sring.hw4.model.UserDAO;

@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public login() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserDAO doa = new UserDAO();
		List<UserBean>userid=doa.getAllUsers();
		request.setAttribute("userid",userid);
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		if (session.getAttribute("user") == null){
			String username = request.getParameter("username");
			String pass = request.getParameter("pass");
			UserDAO doa = new UserDAO();
			List<UserBean>userid=doa.getAllUsers();
			request.setAttribute("userid",userid);
			if (username.isEmpty()) {
				request.setAttribute("error", "Please enter Email");		
				request.getRequestDispatcher("login.jsp").forward(request, response);
				return;
			}
			if (pass.isEmpty()) {
				request.setAttribute("error", "Please enter password");
				request.setAttribute("username", username);			
				request.getRequestDispatcher("login.jsp").forward(request, response);
				return;
			}
			
		
			boolean status =doa.checkUser(username, pass);
			if	(status){
				UserBean um=doa.getUserByEmail(username);
			session.setAttribute("user", um.getId());
			session.setAttribute("fname", um.getfName());
			session.setAttribute("lname", um.getlName());
			
			response.sendRedirect("home");
			return;
			}
			else{
				
				request.setAttribute("error", "Wrong username/password");
				request.setAttribute("username", username);	
			
				request.getRequestDispatcher("login.jsp").forward(request, response);
				return;
			}
			
		}
		else{
			response.sendRedirect("home");
		}
		request.setAttribute("error", "Error, Please try again");
		
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

}
