package ahmed.mabrouk.gestiondestock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ahmed.mabrouk.gestiondestock.controller.api.ArticleApi;
import ahmed.mabrouk.gestiondestock.dto.ArticleDto;
import ahmed.mabrouk.gestiondestock.dto.LigneCommandeClientDto;
import ahmed.mabrouk.gestiondestock.dto.LigneCommandeFournisseurDto;
import ahmed.mabrouk.gestiondestock.dto.LigneVenteDto;
import ahmed.mabrouk.gestiondestock.service.ArticleService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController implements ArticleApi {
	
	private ArticleService articleService;
	
	
	@Autowired
	public ArticleController(ArticleService articleService) {
		this.articleService = articleService;
	}

	@Override
	public ArticleDto save(ArticleDto articleDto) {
		// TODO Auto-generated method stub
		return articleService.save(articleDto);
	}

	@Override
	public ArticleDto findById(Integer id) {
		// TODO Auto-generated method stub
		return articleService.findById(id);
	}

	@Override
	public ArticleDto findByCodeArticle(String codeArticle) {
		// TODO Auto-generated method stub
		return articleService.findByCodeArticle(codeArticle);
	}

	@Override
	public List<ArticleDto> findAll() {
		// TODO Auto-generated method stub
		return articleService.findAll();
	}

	@Override
	public List<LigneVenteDto> findHistoriqueVentes(Integer idArticle) {
		// TODO Auto-generated method stub
		return articleService.findHistoriqueVentes(idArticle);
	}

	@Override
	public List<LigneCommandeClientDto> findHistoriaueCommandeClient(Integer idArticle) {
		// TODO Auto-generated method stub
		return articleService.findHistoriauriqueCommandeClient(idArticle);
	}

	@Override
	public List<LigneCommandeFournisseurDto> findHistoriqueCommandeFournisseur(Integer idArticle) {
		// TODO Auto-generated method stub
		return articleService.findHistoriqueCommandeFournisseur(idArticle);
	}

	@Override
	public List<ArticleDto> findAllArticleByIdCategory(Integer idCategory) {
		// TODO Auto-generated method stub
		return articleService.findAllArticleByIdCategory(idCategory);
	}

	@Override
	public void delete(Integer id) {
		articleService.delete(id);
		
	}

}
