

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Add
 */
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out;
		String prod =  (String) request.getSession().getAttribute("prod");
		out = response.getWriter();
		out.println("<html><head><meta charset='UTF-8'><title>Add</title></head><body>");
		out.println("<h1>Add</h1><form action='Addser' method='post'>	Product name:	<input type='text' name='prod' value='"+prod+"'></input><br>	Price:");
		out.println("	<input type='text' name='pric'></input><br>	Description:	<input type='text' name='desc'></input><br>	<input type='submit' value='Add'></input></form> ");
		out.println("</body></html>");
		out.close();
	}

}
