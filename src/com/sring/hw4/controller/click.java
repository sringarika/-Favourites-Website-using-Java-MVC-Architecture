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

@WebServlet("/click")
public class click extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public click() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		try {
		
			String tempid = request.getParameter("fid");
			String favid=tempid;
			String url = request.getParameter("url");
			if(favid.isEmpty()){
				response.sendRedirect("viewurl.jsp");
			}
			if(url.isEmpty()){
				response.sendRedirect("viewurl.jsp");
			}
			FavoriteDAO fbdao= new FavoriteDAO();
			System.out.println("url"+"------------------------");
			fbdao.updateClick(    Integer.parseInt(favid));
			response.sendRedirect(url);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
