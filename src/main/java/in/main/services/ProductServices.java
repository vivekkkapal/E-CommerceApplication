package in.main.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import in.main.entities.Products;

public interface ProductServices {
	
	//Add Products
	public Products addProduct(Products products);
	
	//Get all Products
	public Page<Products> getProducts(Pageable pageable);
	
	//Get Products By ID
	public Optional<Products> getProductById(Long id);
	
	//Update Products
	public Products updateProduct(Products categories, Long id);
	
	//Delete Products
	public void deleteProduct(Long id);

}
