package controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.Customer_dao;
import dto.Product;

@WebServlet("/saveproduct")
@MultipartConfig
public class SaveProduct extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Product product = new Product();
		product.setName(req.getParameter("pname"));
		product.setPrice(Double.parseDouble(req.getParameter("pprice")));
		product.setDescription(req.getParameter("pdesc"));
		
		byte[] pic = null;
		Part filepart = req.getPart("pimg");
		if(filepart != null)
		{
			InputStream inputStream = filepart.getInputStream();
			pic = new byte[inputStream.available()];
			inputStream.read(pic);
		}
		product.setImage(pic);
		Customer_dao dao = new Customer_dao();
		dao.save(product);
		
		resp.getWriter().print("<h1 style='color: blue'> Product Added Successfully</h1>");
		req.getRequestDispatcher("Home.jsp").include(req, resp);
	}
}
