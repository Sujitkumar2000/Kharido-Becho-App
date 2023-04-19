package controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Customer_dao;
import dto.Customer;
@WebServlet("/signup")
public class Signup extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String mobile = req.getParameter("mobile");
		String password = req.getParameter("password");
		String gender = req.getParameter("gender");
		String dob = req.getParameter("dob");
		String address = req.getParameter("address");
		
		Customer_dao dao = new Customer_dao();
		Date date = Date.valueOf(dob);
		int age = Period.between(date.toLocalDate(), LocalDate.now()).getYears();
		if(age<18){
			resp.getWriter().print("<h1 style='color:red'>You can't create account, Your age not 18+</h1>");
			req.getRequestDispatcher("Signup.html").include(req, resp);
		}
		else{
			if(dao.find(Long.parseLong(mobile)).isEmpty() && dao.find(email).isEmpty()){
				Customer customer = new Customer();
				customer.setName(name);
				customer.setEmail(email);
				customer.setMobile(Long.parseLong(mobile));
				customer.setPassword(password);
				customer.setGender(gender);
				customer.setDob(Date.valueOf(dob));
				customer.setAddress(address);
				customer.setAge(age);
				
				dao.save(customer);
				Customer customer2 = dao.find(email).get(0);
				resp.getWriter().print("<h1 style='color:green'>Account crated Successfully<h1>");
				resp.getWriter().print("<h1 style='color:green'>Your Customer Id is : "+customer2.getCustid()+"<h1>");
				req.getRequestDispatcher("Home.jsp").include(req, resp);
			}
			else{
				resp.getWriter().print("<h1 style='color:red'>Can Not Create Account, Mobile Number or Email Already Exists</h1>");
				req.getRequestDispatcher("Signup.html").include(req, resp);
			}	
		}
	}
}
