/**
 * @author sringarikapandey
 * @date Dec 14
 * @course 08-672 A2 J2EE
 */
package com.sring.hw4.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringEscapeUtils;

import com.sring.hw4.model.FavoriteDAO;

@WebServlet("/delfav")
public class delfav extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public delfav() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			if (request.getSession().getAttribute("user") == null){
				response.sendRedirect("login.jsp");
				return;
				}
				String tempid = request.getParameter("fid");
				String favid=tempid;
				if(favid.isEmpty()){
					response.sendRedirect("viewurl.jsp");
				}
				
				FavoriteDAO fbdao= new FavoriteDAO();
				fbdao.delFav(    Integer.parseInt(favid),(int)request.getSession().getAttribute("user"));
				response.getWriter().append("Delete Success");
				return;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
