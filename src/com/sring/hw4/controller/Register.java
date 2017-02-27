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

import com.sring.hw4.BCrypt;
import com.sring.hw4.model.UserBean;
import com.sring.hw4.model.UserDAO;

@WebServlet("/register")
public class Register extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generaed method stub
		UserDAO doa = new UserDAO();
		List<UserBean>userid=doa.getAllUsers();
		request.setAttribute("userid",userid);
		request.getRequestDispatcher("register.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		String rpass = request.getParameter("rpass");
		UserDAO doa = new UserDAO();
		List<UserBean>userid=doa.getAllUsers();
		request.setAttribute("userid",userid);
		if (fname.isEmpty()) {
			request.setAttribute("error", "Please enter first name");
			request.setAttribute("lname", lname);
			request.setAttribute("email", email);
			request.getRequestDispatcher("register.jsp").forward(request, response);
			return;
		}

		if (lname.isEmpty()) {
			request.setAttribute("error", "Please enter Last name");
			request.setAttribute("fname", fname);
			request.setAttribute("email", email);
			request.getRequestDispatcher("register.jsp").forward(request, response);
			return;
		}
		if (email.isEmpty()) {
			request.setAttribute("error", "Please enter Email");
			request.setAttribute("lname", lname);
			request.setAttribute("fname", fname);
			request.getRequestDispatcher("register.jsp").forward(request, response);
			return;
		}
		if (pass.isEmpty() || (!pass.equals(rpass))) {
			request.setAttribute("error", "Password do not match or empty");
			request.setAttribute("lname", lname);
			request.setAttribute("fname", fname);
			request.setAttribute("email", email);
			request.getRequestDispatcher("register.jsp").forward(request, response);
			return;
		}

		UserBean usr = new UserBean();
		usr.setEmail(email);
		usr.setfName(fname);
		usr.setlName(lname);
		 String hash_pass = BCrypt.hashpw(pass, BCrypt.gensalt());
		usr.setPass(hash_pass);
		usr.setActive(true);
		//UserManagementDOA doa = new UserManagementDOA();
		try {
			doa.addUser(usr);
		} catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e) {
			// TODO Auto-generated catch block
			
			request.setAttribute("error", "Email already exits.");
			request.setAttribute("lname", lname);
			request.setAttribute("fname", fname);
			request.setAttribute("email", email);
			
			request.getRequestDispatcher("register.jsp").forward(request, response);
			e.printStackTrace();
			return;
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		HttpSession session = request.getSession();
			session.setAttribute("user",doa.getUserByEmail(email).getId());
			
			session.setAttribute("fname", fname);
			session.setAttribute("lname", lname);
			
			response.sendRedirect("home");
			}

}
