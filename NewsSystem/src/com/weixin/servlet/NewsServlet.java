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
import com.google.gson.GsonBuilder;
import com.weixin.bean.News;
import com.weixin.bean.PhotoBrowser;
import com.weixin.util.DbUtils;

@WebServlet("/NewsServlet/*")
public class NewsServlet extends HttpServlet {
	QueryRunner qr = new QueryRunner();
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String path =  request.getPathInfo().substring(1);
		if("findAllByKind".equals(path)) {
			findAllByKind(request,response);
		}else if("findNewByNewsId".equals(path)) {
			findNewByNewsId(request,response);
		}else if("findPhotoBrowserByNewsId".equals(path)) {
			findPhotoBrowserByNewsId(request,response);
		}
	}

	private void findPhotoBrowserByNewsId(HttpServletRequest request, HttpServletResponse response) {
		//获得新闻id:
		String news_id = request.getParameter("news_id");
		//通过新闻id查询所有photobrowser:
		String sql = "select * from photobrowser where news_id="+news_id;
		List<PhotoBrowser> photoBrowsers;
		try {
			photoBrowsers = qr.query(DbUtils.getConnection(), sql, new BeanListHandler<PhotoBrowser>(PhotoBrowser.class));
			String json = new Gson().toJson(photoBrowsers);
			response.getWriter().println(json);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void findNewByNewsId(HttpServletRequest request, HttpServletResponse response) {
		//获得新闻id:
		String news_id = request.getParameter("news_id");
		//通过新闻id查询新闻详情:
		String sql = "select * from news where news_id="+news_id;
		List<News> news;
		try {
			news = qr.query(DbUtils.getConnection(), sql, new BeanListHandler<News>(News.class));
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
			String json = gson.toJson(news);
			response.getWriter().println(json);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void findAllByKind(HttpServletRequest request, HttpServletResponse response){
		String kind = request.getParameter("kind");
		String sql = "select news.*,publisher.title publisher_title,publisher.image\r\n" + 
				"from news,publisher\r\n" + 
				"where news.publisher_id=publisher.publisher_id "+
				"and "+kind+"=1";
		try {
			List<News> news = qr.query(DbUtils.getConnection(), sql, new BeanListHandler<News>(News.class));
//			Gson gson = new Gson();
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
			String json = gson.toJson(news);
			System.out.println(json);
			response.getWriter().println(json);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
