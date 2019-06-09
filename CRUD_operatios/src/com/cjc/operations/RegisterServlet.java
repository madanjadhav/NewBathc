package com.cjc.operations;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.cjc.model.Employee;
import com.oracle.jrockit.jfr.RequestDelegate;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet{
	
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		System.out.println("service method of register");
		Employee e=new Employee();
		e.setEmpid(Integer.parseInt(request.getParameter("empid")));
		e.setName(request.getParameter("name"));
		e.setAddress(request.getParameter("address"));
		e.setMono(request.getParameter("mono"));
		e.setUname(request.getParameter("uname"));
		e.setPass(request.getParameter("pass"));
		System.out.println("all parameters are set");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/crud", "root", "root");
			String sql="insert into employee values("+e.getEmpid()+",'"+e.getName()+"','"+e.getAddress()+"','"+e.getMono()
			+"','"+e.getUname()+"','"+e.getPass()+"')";
			Statement smt=con.createStatement();
			smt.execute(sql);
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
			System.out.println("data inserted successfully");
			
		}
			 catch (SQLException e1) {
			
				e1.printStackTrace();
			}
		 catch (ClassNotFoundException e1) {
			
			e1.printStackTrace();
		}
		
		
		
		
		
	
	}

}
