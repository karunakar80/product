package com.example.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.service.IProductService;

@RestController
@RequestMapping("/product")
public class ProductRestController {
	
	@Autowired
	private IProductService service;
	
	//1.save
	@PostMapping("/create")
	public ResponseEntity<String> createProduct(@RequestBody Product product){
		
		ResponseEntity<String> response=null;
	Integer id=	service.saveProduct(product);
		response=new ResponseEntity<String>("Product'"+ id +"'Created!",HttpStatus.OK);
		return response;
		
	}
	@GetMapping("/all")
	public ResponseEntity<List<Product>> getAllProducts(){
		ResponseEntity<List<Product>> response=null;
		List<Product> list=service.getAllProducts();
		response=new ResponseEntity<List<Product>>(list,HttpStatus.OK);
		return response;
		
	}
	@GetMapping("/find/{id}")
	public ResponseEntity<Product> getOneProduct(@PathVariable Integer id){
		ResponseEntity<Product> response=null;
	Product pob=service.getOneProduct(id);
	response=new ResponseEntity<Product>(pob,HttpStatus.OK);
		return response;
		
	}

	public ResponseEntity<String> deleteOneProduct(@PathVariable Integer id){
		ResponseEntity<String> response=null;
		service.deleteProduct(id);
		response=new ResponseEntity<String>("Product Deleted",HttpStatus.OK);
		return response;
		
	}
	@PutMapping("/update")
	public ResponseEntity<String> updateProduct(@RequestBody Product product ){
		ResponseEntity<String> response=null;
		service.updateProduct(product);
		response=new  ResponseEntity<String> ("Product Updated!",HttpStatus.OK);
		return response;
		
}
}
