package com.retail.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.google.gson.Gson;
import com.retail.dao.BlogDao;
import com.retail.dao.CategoryDao;
import com.retail.model.Blog;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BlogDao blogDao=new BlogDao();
		
		List<Blog> blogList=blogDao.getBlog();
		System.out.println(blogList);
		System.out.println("hit....");
		
		
		System.out.println(blogList.toString());
		
		JSONObject blogJSON = new JSONObject();
		JSONObject formDetailsJson = new JSONObject();
		for (Blog s : blogList) {
			
			formDetailsJson.put("blog",s);
		}
		System.out.println(blogJSON);
		
		
	
		StringWriter jsonwriter=new StringWriter();
		try {
			JSONValue.writeJSONString(blogJSON, jsonwriter);
		} catch (IOException e) {
			
			e.printStackTrace();
		}

		String JSONString=jsonwriter.toString();
		System.out.println(JSONString);

   
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		response.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
	    response.setHeader("Access-Control-Allow-Credentials", "true");
	    response.setHeader("Access-Control-Allow-Methods", "POST,GET,HEAD,OPTIONS");
		response.setHeader("Access-Control-Allow-Headers", "Origin,Accept,x-auth-token,Content-Type,"+"Access-Control-Request-Method,Access-Control-Request-Headers");
		Gson gson =new Gson();
		String gsonCategoryList = gson.toJson(blogList); 
		out.write(gsonCategoryList);
		System.out.println(gsonCategoryList);
		out.flush();
		 /*RequestDispatcher dispatcher=request.getRequestDispatcher("BlogServlet");
	    	dispatcher.include(request, response);
	*/
		out.close();
	}

}
