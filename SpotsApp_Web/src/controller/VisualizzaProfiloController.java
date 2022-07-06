package controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VisualizzaProfiloController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	
	public void init(ServletConfig conf) throws ServletException 
	{
		super.init(conf);		
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
	
		if(req.getParameter("cambiaPW") != null)
		{
			//Logica per cambaire pw
		}
		else if(req.getParameter("inserzioni") != null)
		{
			//LOgica per rimuovere inserzioni
		}
		else if(req.getParameter("logout") != null)
		{
			req.getSession().invalidate();
			resp.sendRedirect("view/ViewLogin.jsp");
		}
	}	

}