package in.main.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import in.main.entities.Products;
import in.main.repo.ProductRepo;

@Service
public class ProductServiceImpl implements ProductServices{
	
	@Autowired
	ProductRepo productRepo;

	@Override
	public Products addProduct(Products products) {
		return productRepo.save(products);
	}

	@Override
	public Page<Products> getProducts(Pageable pageable) {
		Page<Products> productPage = productRepo.findAll(pageable);
		return productPage;
	}

	@Override
	public Optional<Products> getProductById(Long id) {
		return productRepo.findById(id);
	}

	@Override
	public Products updateProduct(Products products, Long id) {
		Products updateProducts = productRepo.findById(id).orElse(null);
		
		if(updateProducts != null) {
			updateProducts.setCategories(products.getCategories());
			updateProducts.setName(products.getName());
			updateProducts.setPrice(products.getPrice());
			return productRepo.save(updateProducts);
		}else {
			throw new RuntimeException("This ID is not Present in the Categories "+id);
		}
	}

	@Override
	public void deleteProduct(Long id) {
		productRepo.deleteById(id);
	}

}
