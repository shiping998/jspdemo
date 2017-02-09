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
 * Servlet implementation class UserloginServlet
 */
public class UserloginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserloginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		  request.setCharacterEncoding("utf-8");
	        response.setCharacterEncoding("utf-8");
	        String userName = request.getParameter("userName");
	        String userPassword = request.getParameter("userPassword");
	        // 前台得到用户输入
	        UserDao userDao=new UserDao();
	        UserVo user=userDao.judgeUserPassword(userName, userPassword);
	        String message="用户名或者密码错误";
	        if(user==null){
	        	request.setAttribute("message", message);
	        	request.getRequestDispatcher("/userlogin.jsp").forward(request,response);
	        } else {
	            // 如果用户存在，检索数据，跳到用户列表显示页面
	            ArrayList<UserVo> list = userDao.selectNotDeleteList();
	            request.setAttribute("list", list);
	            request.getRequestDispatcher("/userlist.jsp").forward(request,response);
	        }
	        
	}

}
