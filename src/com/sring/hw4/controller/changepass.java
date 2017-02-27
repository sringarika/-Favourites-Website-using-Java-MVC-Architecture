/**
 * @author sringarikapandey
 * @date Dec 14
 * @course 08-672 A2 J2EE
 * 
 */
package com.sring.hw4.controller;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringEscapeUtils;

import com.sring.hw4.model.UserBean;
import com.sring.hw4.model.UserDAO;

@WebServlet("/changepass")
public class changepass extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public changepass() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getSession().getAttribute("user") == null){
			response.sendRedirect("login");
			return;
		}UserDAO doa = new UserDAO();
		List<UserBean>userid=doa.getAllUsers();
		request.setAttribute("userid",userid);
		request.getRequestDispatcher("changepass.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserDAO doa = new UserDAO();
		List<UserBean>userid=doa.getAllUsers();
		request.setAttribute("userid",userid);
		String pass = request.getParameter("pass");
		String rpass = request.getParameter("rpass");
		String opass = request.getParameter("opass");
		if(opass.isEmpty()){
			request.setAttribute("error", "Password cannot be empty");
			request.getRequestDispatcher("changepass.jsp").forward(request, response);
			return;
		}
		if (pass.isEmpty() || (!pass.equals(rpass))) {
			request.setAttribute("error", "Password do not match or empty");
			
			request.getRequestDispatcher("changepass.jsp").forward(request, response);
			return;
		}
		int k=(int) request.getSession().getAttribute("user");
		UserBean usr=doa.getUserByID(k);
		if(doa.checkUser(usr.getEmail(), opass)){
			if(doa.changePass(String.valueOf(k), opass, pass)){
				request.setAttribute("error", "Password Changed Successfully");
				
				request.getRequestDispatcher("changepass.jsp").forward(request, response);
				return;
			}
			else{
				request.setAttribute("error", "Error in ");
				
				request.getRequestDispatcher("changepass.jsp").forward(request, response);
				return;
			}
			
		}
		else{
			request.setAttribute("error", "Password do not match.");
			
			request.getRequestDispatcher("changepass.jsp").forward(request, response);
			return;
		}
		
		
	}

}
