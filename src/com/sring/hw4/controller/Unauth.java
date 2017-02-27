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

import org.apache.commons.lang3.StringEscapeUtils;

import com.sring.hw4.model.FavBean;
import com.sring.hw4.model.FavoriteDAO;
import com.sring.hw4.model.UserBean;
import com.sring.hw4.model.UserDAO;

@WebServlet("/Unauth")
public class Unauth extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public Unauth() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FavoriteDAO fbdao = new FavoriteDAO();
		String tempid = request.getParameter("id");
		List<FavBean> fblist=fbdao.getAllFavByUserID( Integer.parseInt(tempid));
		request.setAttribute("list",fblist);
		UserDAO doa = new UserDAO();
		List<UserBean>userid=doa.getAllUsers();
		request.setAttribute("userid",userid);
		request.getRequestDispatcher("unauth.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
