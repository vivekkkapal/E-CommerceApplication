package in.main.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.main.entities.Categories;

public interface CategoryRepo extends JpaRepository<Categories, Long> {

	
}
