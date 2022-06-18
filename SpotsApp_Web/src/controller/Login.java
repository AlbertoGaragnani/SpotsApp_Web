package controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class Login extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private Gson gson;
	
	public void init(ServletConfig conf) throws ServletException {
		super.init(conf);
		gson = new Gson();
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		//Restituzione dati in AJAX
		String res = "";
		res = gson.toJson(res);
		resp.getWriter().println(res);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
	}

}
