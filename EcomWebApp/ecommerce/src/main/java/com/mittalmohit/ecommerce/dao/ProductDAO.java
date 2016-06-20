package com.mittalmohit.ecommerce.dao;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import com.mittalmohit.ecommerce.pojo.Product;
import com.mittalmohit.ecommerce.pojo.Seller;

public class ProductDAO extends DAO {

	public Product addProducts(String title, String category, String description, int quantity, double price, Seller seller) {
		try{
			begin();
			Product product = new Product();
			product.setTitle(title);
			product.setCategory(category);
			product.setDescription(description);
			product.setQuantity(quantity);
			product.setPrice(price);
			List<Product> products = new ArrayList<Product>(); 
			products.add(product);
			product.setSeller(seller);
			seller.setProducts(products);
			getSession().saveOrUpdate(product);
			commit();
			return product;	
		}catch(Exception e){
			rollback();
			System.out.println("Exception adding: " + e.getMessage());
			return null;
		}
	}

	public List<Product> viewProducts(Seller seller) {
		begin();
        Query q = getSession().createQuery("from Product where seller = "+ seller.getId());
        List list = q.list();
        commit();
        return list;
	}
}
