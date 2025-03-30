package in.main.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import in.main.entities.Categories;
import in.main.repo.CategoryRepo;

@Service
public class CatServiceImpl implements CatServices{
	
	@Autowired
	CategoryRepo categoryRepo;

	@Override
	public Categories addCategories(Categories categories) {
		return categoryRepo.save(categories);
	}

	@Override
	public Page<Categories> getCategories(Pageable pageable) {
		Page<Categories> categories = categoryRepo.findAll(pageable);
		return categories;
	}

	@Override
	public Optional<Categories> getCateroryById(Long id) {
		return categoryRepo.findById(id);
	}

	@Override
	public Categories updateCategory(Categories categories, Long id) {
		Categories updateCategories = categoryRepo.findById(id).orElse(null);
		
		if(updateCategories != null) {
			updateCategories.setCatName(categories.getCatName());
			updateCategories.setProducts(categories.getProducts());
			return categoryRepo.save(updateCategories);
		}else {
			throw new RuntimeException("This ID is not Present in the Categories "+id);
		}
	}

	@Override
	public void deleteCategory(Long id) {
		categoryRepo.deleteById(id);
	}

	
}
