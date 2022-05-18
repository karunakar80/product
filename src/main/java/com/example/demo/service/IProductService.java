package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Product;

public interface IProductService {

	Integer saveProduct(Product p);
	void updateProduct(Product p);
	void deleteProduct(Integer id);
	Product getOneProduct(Integer id);
	List<Product> getAllProducts();
	
}
