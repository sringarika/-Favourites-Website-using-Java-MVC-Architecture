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

@WebServlet("/addurl")
public class addurl extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public addurl() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getSession().getAttribute("user") == null){
			response.sendRedirect("login");
		}
		System.out.println(request.getSession().getAttribute("user"));
		String url=request.getParameter("url");
		String cmnt=request.getParameter("cmnt");
		UserDAO doa = new UserDAO();
        List<UserBean>userid=doa.getAllUsers();
        request.setAttribute("userid",userid);
		if(url.isEmpty()){
			request.setAttribute("error", "Please enter URL, its required");
			request.setAttribute("cmnt", cmnt);
			request.getRequestDispatcher("home.jsp").forward(request, response);
			return;
		}
		if(!url.contains("http://")  && !url.contains("https://")){
			url="http://"+url;
		}
	
		try {
			FavBean fb= new FavBean();
			
			fb.setUserid((int) request.getSession().getAttribute("user"));
			fb.setActive(1);
			fb.setUrl(url);
			fb.setComment(cmnt);
			fb.setClick(0);
			FavoriteDAO fbDao= new FavoriteDAO();
			fbDao.addfav(fb);
			
			fb=null;
			response.sendRedirect("home");
			return;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
