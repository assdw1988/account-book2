package jap.com;

import java.io.IOException;

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
@WebServlet("/web002")
public class web002 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public web002() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Start Web002");
	    request.setCharacterEncoding("Shift_JIS");
	    response.setContentType("text/html;charset=Shift_JIS");
	    
	    String tempStr = request.getParameter("tra1");
	    ServletContext context = this.getServletContext();
		String path = context.getRealPath("WEB-INF/data.txt");
		
		MyDataModel md = new MyDataModel(path);
		md.setData(tempStr);
		md.saveData();
		
		RequestDispatcher dispatcher = context.getRequestDispatcher("/success.jsp");
		dispatcher.include(request, response);
	}
}
