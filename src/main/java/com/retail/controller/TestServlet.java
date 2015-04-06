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

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.google.gson.Gson;
import com.retail.dao.CategoryDao;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		CategoryDao dao=new CategoryDao();
		
		List<String> cat=dao.getCategory();
		System.out.println(cat);
		System.out.println("hit....");
		
		
		System.out.println(cat);
		
		JSONObject responseDetailsJson = new JSONObject();
		JSONObject formDetailsJson = new JSONObject();
		for (String s : cat) {
			formDetailsJson.put("categoryName",s);
		}
		System.out.println(responseDetailsJson);
		
		
	
		StringWriter jsonwriter=new StringWriter();
		try {
			JSONValue.writeJSONString(responseDetailsJson, jsonwriter);
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
		String gsonCategoryList = gson.toJson(cat); 
		out.write(gsonCategoryList);
		System.out.println(gsonCategoryList);
		out.flush();
		 RequestDispatcher dispatcher=request.getRequestDispatcher("BlogServlet");
	    	dispatcher.include(request, response);
	
		out.close();
		
	}

}
