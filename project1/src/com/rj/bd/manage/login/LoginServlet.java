package com.rj.bd.manage.login;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(urlPatterns ="/manage/manager.do")
public class LoginServlet extends HttpServlet {

	LoginService serivece = new LoginService();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("method");
		System.out.println(method);
		try {
			if (method.equals("query")) {
				this.queryToManager(request, response);
			}else if(method.equals("yanzheng")){
				this.yanzheng(request,response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	private void yanzheng(HttpServletRequest request, HttpServletResponse response) {
		
	}

	/**
	 * @desc 查询管理员账号和密码
	 * @param request
	 * @param response
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws ServletException
	 */
	private void queryToManager(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, SQLException, ServletException, IOException {
		String code = request.getParameter("code");
	   String	yanzheng=request.getParameter("yanzheng");
	   System.out.println(yanzheng);
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		Map<String, Object> map = serivece.queryToManager(name, password);
		if (map != null) {
			request.getRequestDispatcher("/list.jsp").forward(request, response);
		} else {
			request.setAttribute("errorMsg", "用户名或者密码有误，请重新输入");
			request.getRequestDispatcher("/manage/error.jsp").forward(request, response);
		}
	}

}
