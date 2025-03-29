package in.main.controller;

import org.springframework.web.bind.annotation.RestController;

import in.main.entities.Categories;
import in.main.services.CatServiceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
public class CategoriesController {
	
	@Autowired
	CatServiceImpl catServiceImpl;
	
	
	@PostMapping("/api/categories")
	public Categories createCategory(@RequestBody Categories categories) {
		
		return catServiceImpl.addCategories(categories);
	}
	
	@GetMapping("/api/categories")
    public ResponseEntity<Page<Categories>> getAllCategories(@PageableDefault(page = 0, size = 10) Pageable pageable) {
        return ResponseEntity.ok(catServiceImpl.getCategories(pageable));
    }
	
	
	@GetMapping("/api/categories/{id}")
	public ResponseEntity<Categories> getMethodName(@PathVariable Long id) {
		Categories category = catServiceImpl.getCateroryById(id).orElse(null);
		
		if(category != null) {
			
			return ResponseEntity.ok().body(category);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping("/api/categories/{id}")
	public ResponseEntity<Categories> updateCategoryById(@RequestBody Categories UpdatedCategory, @PathVariable Long id) {
		Categories categories = catServiceImpl.updateCategory(UpdatedCategory, id);
		
		if(categories != null) {
			return ResponseEntity.ok().body(categories);
		}else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	
	@DeleteMapping("/api/categories/{id}")
	public ResponseEntity<Void> putMethodName(@PathVariable Long id) {
		catServiceImpl.deleteCategory(id);
		return ResponseEntity.noContent().build();
	}
	
	
	
	

}
