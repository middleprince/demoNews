package com.weixin.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;

import com.weixin.util.DbUtils;

@WebServlet("/UserServlet/*")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String path = request.getPathInfo().substring(1);
		if("register".equals(path)) {
			register(request,response);
		}
	}

	private void register(HttpServletRequest request, HttpServletResponse response) {
		String openId = request.getParameter("openId");
		String nickName = request.getParameter("nickname");
		String head = request.getParameter("head");
		
		//插入数据库：
		String sql = "insert into user values(?,?,?)";
		QueryRunner qr = new QueryRunner();
		try {
			int n = qr.update(DbUtils.getConnection(), sql,openId,nickName,head);
			if(n==1) {
				response.getWriter().println("{\"status\":1}");
			}else {
				response.getWriter().println("{\"status\":0}");
			}
		} catch (Exception e) {
			try {
				response.getWriter().println("{\"status\":0}");
			} catch (IOException e1) {
//				e1.printStackTrace();
			}
//			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
