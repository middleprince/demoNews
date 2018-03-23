package com.weixin.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;

import com.jspsmart.upload.Files;
import com.jspsmart.upload.SmartUpload;
import com.weixin.util.DbUtils;

@WebServlet("/CircleServlet/*")
public class CircleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getPathInfo().substring(1);
		System.out.println("visited");
		if("upload".equals(path)) {
			upload(request,response);
		}
	}

	private void upload(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("upload visited");
			//上传准备：
		try {
				SmartUpload smart = new SmartUpload();
				smart.initialize(getServletConfig(), request, response);
				smart.setCharset("utf-8");
				
				String[] arrImg = {"","","","","",""};
				
				//上传：
					smart.upload();
					//处理表单
					String text = smart.getRequest().getParameter("text");
					String address = smart.getRequest().getParameter("address");
					String openId = smart.getRequest().getParameter("openId");
					//处理上传文件：
					System.out.println(text);
//					String imgPath= DBUtil.myVirtualPath+"image/circle/"+id+"/";
					String imgPath = "/image/circle/"+openId; 
					
					String realPath = request.getServletContext().getRealPath(imgPath);
					File file = new File(realPath);
					file.mkdirs();
					System.out.println(realPath);
					System.out.println(openId);

//					
					Files files = smart.getFiles();
					for (int i = 0; i < files.getCount(); i++) {
						System.out.println(files.getFile(i).getFileName());
						if(!files.getFile(i).isMissing()){
							//获得后缀名：
							String ext = files.getFile(i).getFileExt();
							String upload_fileName = UUID.randomUUID()+"."+ext;
							files.getFile(i).saveAs(realPath+"/"+upload_fileName);
							arrImg[i]  = "image/circle/"+openId+"/"+upload_fileName;
						}
					}
					
					//数据库操作：
					QueryRunner qr = new QueryRunner();
					String sql = "insert into circle values(null,?,?,?,?,?,?,?,?,?,?)";
					int n = qr.update(DbUtils.getConnection(), sql,text,arrImg[0],arrImg[1],arrImg[2],arrImg[3],arrImg[4],arrImg[5],new Date(),openId,address);
					if(n==1) {
						response.getWriter().println("{\"status\":1}");
					}else {
						response.getWriter().println("{\"status\":0}");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
