package jap.com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class web001
 */
@WebServlet("/Accountlist")
public class Accountlist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Accountlist() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doFire(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doFire(request,response);
	}
	
	private void doFire(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("Shift_JIS");
	    response.setContentType("text/html;charset=Shift_JIS");
        
	    
	    
	    request.setAttribute("temp", "var tbody = [[\"201301\",\"admin\",\"テスト１\",\"テスト２\",\"テスト３\",oper],[\"201302\",\"uimaker\",\"小牛\",\"山东济南\",\"山东大学\",oper]]");
	    
	    ServletContext context = this.getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/table.jsp");
		dispatcher.forward(request, response);
	}
	
	public void checkBean(ServletContext context) {
	    String path = context.getRealPath("WEB-INF/data.txt");
	    context.setAttribute("datamodel", new MyDataModel(path));
	}
}
