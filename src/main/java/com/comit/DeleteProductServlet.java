package com.comit;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/delete_product.do")
public class DeleteProductServlet extends HttpServlet {
	
	private ProductService productService = new ProductService();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int productId = Integer.parseInt(request.getParameter("productId"));
		
		productService.deleteProduct(productId);

		request.setAttribute("products", productService.getProducts());
		request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
	}
}
