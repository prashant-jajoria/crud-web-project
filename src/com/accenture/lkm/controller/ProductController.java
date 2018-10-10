package com.accenture.lkm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accenture.lkm.entity.Product;
import com.accenture.lkm.service.ProductFacade;
import com.accenture.lkm.service.ProductServiceImpl;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/ProductController")
public class ProductController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
	// Views to be used
	private static final String PRODUCTS_LIST = "/productListJSTL.jsp";
	private static final String PRODUCT_FORM = "/product.jsp";	
	private ProductFacade facade = null;
   
	
    public ProductController() 
    {
        super();
        
        facade = new ProductServiceImpl();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// fetch the action parameter
		String action = request.getParameter("action");
		String forwardURL = null;
		
		if(action.equals("list"))
		{
			forwardURL = PRODUCTS_LIST;
		}
		else if(action.equals("add"))
		{
			Product product = new Product();
			request.setAttribute("product", product);
			forwardURL= PRODUCT_FORM;
		}
		else if(action.equals("save"))
		{
			Product product = getProduct(request);
			
			if( product.getId() != 0 )
			{
				facade.updateProduct(product);
			}
			else
			{
				facade.addProduct(product);
			}
			
			forwardURL = PRODUCTS_LIST;
		}
		else if(action.equals("delete"))
		{
			int id = Integer.parseInt(request.getParameter("id"));
			facade.deleteProduct(id);
			forwardURL = PRODUCTS_LIST;
		}
		else if(action.equals("edit"))
		{
			int id =  Integer.parseInt(request.getParameter("id"));
			Product product = facade.getProductById(id);
			request.setAttribute("product", product);
			forwardURL = PRODUCT_FORM;
		}
		
		
		// prepare data here
		List<Product> products = facade.getAllProducts();
		
		// pass our data
		request.setAttribute("products", products);
		
		RequestDispatcher rd = request.getRequestDispatcher(forwardURL);
		rd.forward(request, response);
	}

	private Product getProduct(HttpServletRequest request) 
	{
		Product product = new Product();
		
		product.setId(Integer.parseInt(request.getParameter("id")));
		product.setName(request.getParameter("name"));
		product.setBrand(request.getParameter("brand"));
		product.setPrice( Double.parseDouble(request.getParameter("price")));
		product.setDescription(request.getParameter("description"));
		
		return product;
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
