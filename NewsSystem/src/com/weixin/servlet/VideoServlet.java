package com.weixin.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.google.gson.Gson;
import com.weixin.bean.PhotoBrowser;
import com.weixin.bean.Video;
import com.weixin.util.DbUtils;

@WebServlet("/VideoServlet/*")
public class VideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String path =  request.getPathInfo().substring(1);
		if("findAll".equals(path)) {
			findAll(request,response);
		}
		
		
	}
	private void findAll(HttpServletRequest request, HttpServletResponse response) {	
		String sql = "select * from video";
		QueryRunner qr =new QueryRunner();
		List<Video> videos;
		try {
			videos = qr.query(DbUtils.getConnection(), sql, new BeanListHandler<Video>(Video.class));
			response.getWriter().println(new Gson().toJson(videos));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
