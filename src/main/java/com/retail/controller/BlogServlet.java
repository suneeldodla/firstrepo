package com.retail.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.retail.dao.BlogDao;
import com.retail.model.Blog;
import com.retail.model.Category;

@WebServlet("/BlogServlet")
public class BlogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public BlogServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(">>>>>>>>>>>>>>>>>>>>>> Hitting servlet");
		StringBuffer sb = new StringBuffer();
		try {
			BufferedReader reader = request.getReader();
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONParser parser = new JSONParser();
		JSONObject joProduct = null;
		
			try {
				joProduct = (JSONObject)parser.parse(sb.toString());
			} catch (org.json.simple.parser.ParseException e) {
				e.printStackTrace();
			}
		
		String blogTitle=(String) joProduct.get("blogName");
		System.out.println(blogTitle);
		String blogContent=(String) joProduct.get("blogContent");
		//String image=(String) joProduct.get("blogImage");
	//	String[] imageString=image.split("");
		String calender=(String) joProduct.get("calender");
		String categoryName =(String) joProduct.get("categoryName");
//		Category category = new Category();
//		category.setCategoryName(categoryName);
		//byte[][] byteImage = convertToBytes(imageString);
		Blog blog= new  Blog();
		blog.setBlogContent(blogContent);
		blog.setBlogName(blogTitle);
		blog.setBlogDate(calender);
		//blog.setImage(byteImage);
		//blog.setCategory(category);
		BlogDao blogdao= new BlogDao();
		blogdao.insertBlog(blog);
		//catDao.insertCategory(category);
		PrintWriter pw=response.getWriter();
		pw.println(blog);

		response.setContentType("text/html");
		response.setHeader("Access-Control-Allow-Origin",
				"http://localhost:8080");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Allow-Methods",
				"POST,GET,HEAD,OPTIONS");
		response.setHeader(
				"Access-Control-Allow-Headers",
				"Origin,Accept,x-auth-token,Content-Type,Access-Control-Request-Method,Access-Control-Request-Headers");
		System.out.println("end of blog servlet");
			

	}
	

}
