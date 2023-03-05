package ahmed.mabrouk.gestiondestock.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ahmed.mabrouk.gestiondestock.model.Article;
import org.springframework.data.jpa.repository.Query;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
	
	 Optional<Article> findArticleByCodeArticle(String codeArticle);

	  List<Article> findAllByCategoryId(Integer idCategory);

}
