package com.user.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.dao.UserDao;
import com.user.vo.UserVo;

/**
 * Servlet implementation class ServletToUserUpdate
 */

public class ServletToUserUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletToUserUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		  int userId = Integer.parseInt(request.getParameter("userId"));
	        UserDao userDao = new UserDao();
	        UserVo user = userDao.selectOneUserInfo(userId);
	        request.setAttribute("user", user);
	        request.getRequestDispatcher("/userupdate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		int userId = Integer.parseInt(request.getParameter("userId"));
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String userName=request.getParameter("userName");
		String userPassword=request.getParameter("userPassword");
		String userSex=request.getParameter("userSex");
		UserVo user=new UserVo();
		user.setUserName(userName);
		user.setUserPassword(userPassword);
		user.setUserSex(userSex);
		user.setUserId(userId);
		
		UserDao userDao = new UserDao();
		userDao.updateUser(user);  
		ArrayList<UserVo> list=userDao.selectNotDeleteList();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/userlist.jsp").forward(request, response);
	}

}
