package ahmed.mabrouk.gestiondestock.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ahmed.mabrouk.gestiondestock.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

	  Optional<Category> findCategoryByCode(String code);
}
