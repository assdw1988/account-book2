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
@WebServlet("/web001")
public class web001 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public web001() {
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
	    
		String hid1 = request.getParameter("hid1");
        System.out.println("hid1=" + hid1);
        
        getAll();
        
	    ServletContext context = this.getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/success.jsp");
	    this.checkBean(context);
		dispatcher.include(request, response);
	}
	
	public void checkBean(ServletContext context) {
	    String path = context.getRealPath("WEB-INF/data.txt");
	    context.setAttribute("datamodel", new MyDataModel(path));
	}
	
	private static Connection getConn(){
	    String url="jdbc:oracle:thin:@localhost:1521:orcl";
	    String user="zhanyang";
	    String password="g19880520";
	    Connection conn = null;
	    try {
	      Class.forName("oracle.jdbc.driver.OracleDriver");
	      conn = DriverManager.getConnection(url,user,password);
	      System.out.println("Connection create ok");
		} catch (Exception e) {
			e.printStackTrace();
		}
	    return conn;
	}
	
	private static void getAll() {
	    Connection conn = getConn();
	    String sql = "select * from c_m_user";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement)conn.prepareStatement(sql);
	        ResultSet rs = pstmt.executeQuery();
	        int col = rs.getMetaData().getColumnCount();
	        System.out.println("============================");
	        while (rs.next()) {
	            for (int i = 1; i <= col; i++) {
	                System.out.print(rs.getString(i) + "\t");
	                if ((i == 2) && (rs.getString(i).length() < 8)) {
	                    System.out.print("\t");
	                }
	             }
	            System.out.println("");
	        }
	            System.out.println("============================");
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
}
