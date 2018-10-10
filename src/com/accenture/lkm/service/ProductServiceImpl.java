package com.accenture.lkm.service;

import java.sql.SQLException;
import java.util.List;

import com.accenture.lkm.dao.ProductDAO;
import com.accenture.lkm.entity.Product;
import com.accenture.lkm.exception.ProductGenericException;

public class ProductServiceImpl implements ProductFacade 
{
	private ProductDAO dao = null;

	public ProductServiceImpl() 
	{
		dao = new ProductDAO();
	}

	public List<Product> getAllProducts() 
	{
		List<Product> products = null;

		try {
			products = dao.list();

			if (products.size() < 1) {
				throw new ProductGenericException("No products Available in table", new Exception());
			}

		} catch (ClassNotFoundException | SQLException ex) {
			ex.printStackTrace();
		} catch (ProductGenericException ex) {
			System.out.println(ex.getMessage());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}

		return products;
	}

	@Override
	public boolean addProduct(Product product) 
	{
		boolean added = false;
		
		
			try {
				added =  dao.add(product);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		return added;
	}

	@Override
	public boolean deleteProduct(int id) 
	{
		boolean deleted = false;
		
		try {
			deleted = dao.delete(id);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return deleted;
	}

	@Override
	public Product getProductById(int id) 
	{
		Product product = null;
		
		try {
			product = dao.get(id);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return product;
	}

	@Override
	public boolean updateProduct(Product product) 
	{
		boolean updated = false;
		
		try {
			updated = dao.update(product);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return updated;
	}
}