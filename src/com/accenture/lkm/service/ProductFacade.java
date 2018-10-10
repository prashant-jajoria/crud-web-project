package com.accenture.lkm.service;

import java.util.List;

import com.accenture.lkm.entity.Product;

public interface ProductFacade
{
	List<Product> getAllProducts();
	
	boolean addProduct(Product product);
	
	boolean deleteProduct(int id);
	
	Product getProductById(int id);

	boolean updateProduct(Product product);
}