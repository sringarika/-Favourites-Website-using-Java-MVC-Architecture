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

import com.sring.hw4.model.FavBean;
import com.sring.hw4.model.FavoriteDAO;
import com.sring.hw4.model.UserBean;
import com.sring.hw4.model.UserDAO;

@WebServlet("/home")
public class home extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public home() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getSession().getAttribute("user") == null){
			response.sendRedirect("login");
			return;
		}
		FavoriteDAO fbdao = new FavoriteDAO();
		List<FavBean> fblist=fbdao.getAllFavByUserID((int) request.getSession().getAttribute("user"));
		request.getSession().setAttribute("list",fblist);
		System.out.println("this is me"+fblist.size());
		request.getSession().setAttribute("fname", request.getSession().getAttribute("fname"));
		request.getSession().setAttribute("lname", request.getSession().getAttribute("lname"));
		UserDAO doa = new UserDAO();
		List<UserBean>userid=doa.getAllUsers();
		request.setAttribute("userid",userid);
		request.getRequestDispatcher("home.jsp").forward(request, response);
		return;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
