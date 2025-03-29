package in.main.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import in.main.entities.Categories;

public interface CatServices {

	//Add Category
	public Categories addCategories(Categories category);
	
	//Get all Categories
	public Page<Categories> getCategories(Pageable pageable);
	
	//Get Category By ID
	public Optional<Categories> getCateroryById(Long id);
	
	//Update Category
	public Categories updateCategory(Categories categories, Long id);
	
	//Delete Category
	public void deleteCategory(Long id);
	
}
