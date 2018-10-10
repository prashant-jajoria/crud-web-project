package com.accenture.lkm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.accenture.lkm.entity.Product;
import com.accenture.lkm.exception.ProductGenericException;
import com.accenture.lkm.utility.DBUtil;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

public class ProductDAO
{
	private Connection connection = null;
	private static Statement stmt = null;
    private static ResultSet rs = null;
    private static PreparedStatement ps = null;
	
    
    public List<Product> list() throws ClassNotFoundException, SQLException, ProductGenericException, Exception
    {
			connection = DBUtil.getDbConnection();
			String selectSQL = "select * from product";
			 
			System.out.println("Connected to Database : " + connection.getMetaData().getDatabaseProductName());

            stmt = connection.createStatement();

            rs = stmt.executeQuery(selectSQL);

            List<Product> products = new ArrayList<>();

			Product product = null;

            while (rs.next()) 
            {
				product = new Product();
				
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getDouble("price"));
				product.setBrand(rs.getString("brand"));
				product.setDescription(rs.getString("description"));

                products.add(product);
            }
            
            stmt.close();
            rs.close();
            DBUtil.closeConnection();

		return products;
	}
    
    public boolean add(Product product) throws ClassNotFoundException, SQLException, Exception
    {
    	String insertSql = "INSERT into product(name,brand,price,description) VALUES (?,?,?,?)";
    	connection = DBUtil.getDbConnection();
    	ps = connection.prepareStatement(insertSql);
    	
    	ps.setString(1, product.getName());
    	ps.setString(2, product.getBrand());
    	ps.setDouble(3, product.getPrice());
    	ps.setString(4, product.getDescription());
    	
    	int result = ps.executeUpdate();
    	
    	ps.close();
    	connection.close();
    	
    	if(result == 1)
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    	
    }
    
    
    
    public boolean delete(int id) throws ClassNotFoundException, SQLException, Exception
    {
    	String deleteSql = "DELETE FROM product where id = ?";
    	
    	connection = DBUtil.getDbConnection();
    	ps = connection.prepareStatement(deleteSql);
    	
    	ps.setInt(1,id);
    	
    	int result = ps.executeUpdate();
    	
    	ps.close();
    	connection.close();
    	
    	if(result == 1)
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    	
    }
    
    public Product get(int id) throws ClassNotFoundException, SQLException, Exception
    {
    	Product product = null;
    	
    	String selectSql = "SELECT * FROM product where id =?";
    	
    	connection = DBUtil.getDbConnection();
    	ps = connection.prepareStatement(selectSql);
    	ps.setInt(1,id);
    
    	rs = ps.executeQuery();
    	
    	if(rs.next())
    	{
    		product = new Product();
    		
    		product.setId(rs.getLong("id"));
    		product.setName(rs.getString("name"));
    		product.setBrand(rs.getString("brand"));
    		product.setPrice(rs.getDouble("price"));
    		product.setDescription(rs.getString("description"));
    	}
    	
    	ps.close();
    	rs.close();
    	connection.close();
    	
    	return product;
    }

	public boolean update(Product product) throws ClassNotFoundException, SQLException, Exception 
	{
		String updateSql = "UPDATE product SET name =?,brand=?,price=?,description=? WHERE id = ?";
    	
		connection = DBUtil.getDbConnection();
    	ps = connection.prepareStatement(updateSql);
    	
    	ps.setString(1, product.getName());
    	ps.setString(2, product.getBrand());
    	ps.setDouble(3, product.getPrice());
    	ps.setString(4, product.getDescription());
    	ps.setLong(5, product.getId());
    	
    	int result = ps.executeUpdate();
    	
    	ps.close();
    	connection.close();
    	
    	if(result == 1)
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
		
	}
    
 
}