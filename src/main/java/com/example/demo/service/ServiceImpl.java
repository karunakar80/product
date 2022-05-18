package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
@Service
public class ServiceImpl implements IProductService{
	@Autowired
	private ProductRepository repo;

	@Override
	public Integer saveProduct(Product p) {
		
		return repo.save(p).getId();
	}

	@Override
	public void updateProduct(Product p) {
		if(p.getId()!=null && repo.existsById(p.getId())) 
				repo.save(p);
	}

	@Override
	public void deleteProduct(Integer id) {
		repo.deleteById(id);
		
	}

	@Override
	public Product getOneProduct(Integer id) {
		return repo.findById(id).get();
	}

	@Override
	public List<Product> getAllProducts() {
		return repo.findAll();
	}

}
