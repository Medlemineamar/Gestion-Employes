package org.example.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mysql.jdbc.Driver;

/**
 * Servlet implementation class EmpFormServlet
 */
@SuppressWarnings("unused")
@WebServlet("/empform")
public class EmpFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpFormServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		String username = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("pass");
		String contact = request.getParameter("contact");
		response.getWriter().append(""+username+"/ "+email);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
//			
//			String url ="jdbc:sqlserver://localhost:1433;databaseName=gestion_emp";
//			String user = "mla";
//			String pass = "12345678";
//		Connection con =   DriverManager.getConnection(url,user,pass);
//		PreparedStatement st  = con.prepareStatement("insert into table sys_users (name,email, tel,password) "+
//				" values ('"+username+"','"+email+"','"+contact+"','"+password+"');" );
//	
//			int r  = st.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
