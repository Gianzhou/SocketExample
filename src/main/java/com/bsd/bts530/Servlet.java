package com.bsd.bts530;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet
 */


public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Location current;  
    private ConnectMySQL cn;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
        current = new Location();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			ServletInputStream sin = request.getInputStream();
			String latParam = request.getParameter("latitude");
			String lonParam = request.getParameter("longitude");
			
			current.setLagitude(latParam);
			current.setLongitude(lonParam);
			
			cn.connectDB();
			cn.insertLocation(current.getLagitude(), current.getLongitude());
			
			
		}catch(IOException e) {
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
