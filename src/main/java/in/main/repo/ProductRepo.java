package in.main.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.main.entities.Products;

public interface ProductRepo extends JpaRepository<Products, Long>{

}
