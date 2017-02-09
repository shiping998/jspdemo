package com.user.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.dao.UserDao;
import com.user.vo.UserVo;

/**
 * Servlet implementation class ServletUserRegister
 */
public class ServletUserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletUserRegister() {
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
		String userName=request.getParameter("userName");
		String userPassword=request.getParameter("userPassword");
		String userSex=request.getParameter("userSex");
		//UserVo user=new UserVo();
		UserDao userDao=new UserDao();
		UserVo user=userDao.judgeuser(userName);
		if(user==null){
			user=new UserVo();
			user.setUserName(userName);
			user.setUserPassword(userPassword);
			user.setUserSex(userSex);
			userDao.insertUser(user);
			request.getRequestDispatcher("/userlogin.jsp").forward(request, response);//转到登陆页面
		}
		else
		{
			 String message="用户名已存在";
			 request.setAttribute("message", message);
			 request.getRequestDispatcher("/userregister.jsp").forward(request, response);//转到注册页面
		}
	}

}
