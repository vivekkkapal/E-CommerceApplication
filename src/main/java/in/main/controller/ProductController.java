package in.main.controller;

import org.springframework.web.bind.annotation.RestController;

import in.main.entities.Products;
import in.main.services.ProductServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
public class ProductController {

	@Autowired
	ProductServiceImpl productServiceImpl;
	
	@PostMapping("/api/products")
	public Products addProducts(@RequestBody Products products) {
		return productServiceImpl.addProduct(products);
	}
	
	@GetMapping("/api/products")
	public ResponseEntity<Page<Products>> getAllProducts(@PageableDefault(page = 0, size = 10) Pageable pageable) {
        return ResponseEntity.ok(productServiceImpl.getProducts(pageable));
    }
	
	@GetMapping("/api/products/{id}")
	public ResponseEntity<Products> getProductById(@PathVariable Long id) {
		Products products = productServiceImpl.getProductById(id).orElse(null);
		
		if(products != null) {
			
			return ResponseEntity.ok().body(products);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	@PostMapping("/api/products/{id}")
	public ResponseEntity<Products> updateProduct(@RequestBody Products UpdatedProduct, @PathVariable Long id) {
		Products products = productServiceImpl.updateProduct(UpdatedProduct, id);
		
		if(products != null) {
			return ResponseEntity.ok().body(products);
		}else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@DeleteMapping("/api/products/{id}")
	public ResponseEntity<Void> putMethodName(@PathVariable Long id) {
		productServiceImpl.deleteProduct(id);
		return ResponseEntity.noContent().build();
	}
	
}
