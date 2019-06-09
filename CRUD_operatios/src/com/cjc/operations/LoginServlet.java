package com.cjc.operations;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.cjc.model.Employee;


@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	
	
	
	
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		System.out.println("login ssservlet service");
		ArrayList<Employee> elist=new ArrayList<>();
		String un=request.getParameter("uname");
		String pw=request.getParameter("pass");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/crud", "root", "root");
			String sql="select * from employee where uname='"+un+"' and pass='"+pw+"'";
			Statement smt=con.createStatement();
			ResultSet rs= smt.executeQuery(sql);
			
			if(rs.next()) {
				sql="select * from employee";
				rs=smt.executeQuery(sql);
				while(rs.next()) {
					Employee e=new Employee();
					e.setEmpid(rs.getInt(1));
					e.setName(rs.getString(2));
					e.setAddress(rs.getString(3));
					e.setMono(rs.getString(4));
					e.setUname(rs.getString(5));
					e.setPass(rs.getString(6));
					elist.add(e);
					
				}
				request.setAttribute("data", elist);
				RequestDispatcher rd=request.getRequestDispatcher("success.jsp");
				rd.forward(request, response);
				
			}
			else {
				request.setAttribute("msg", "Wrong username or password..!");
				RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}
			
			
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}
