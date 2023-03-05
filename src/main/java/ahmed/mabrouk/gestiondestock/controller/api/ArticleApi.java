package ahmed.mabrouk.gestiondestock.controller.api;

import static ahmed.mabrouk.gestiondestock.utils.Constants.APP_ROOT;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import ahmed.mabrouk.gestiondestock.dto.ArticleDto;
import ahmed.mabrouk.gestiondestock.dto.LigneCommandeClientDto;
import ahmed.mabrouk.gestiondestock.dto.LigneCommandeFournisseurDto;
import ahmed.mabrouk.gestiondestock.dto.LigneVenteDto;

public interface ArticleApi {
	
	 @PostMapping(value = APP_ROOT + "/articles/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	  
	  ArticleDto save(@RequestBody ArticleDto dto);

	  @GetMapping(value = APP_ROOT + "/articles/{idArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
	 
	  
	  ArticleDto findById(@PathVariable("idArticle") Integer id);

	  @GetMapping(value = APP_ROOT + "/articles/filter/{codeArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
	 
	  ArticleDto findByCodeArticle(@PathVariable("codeArticle") String codeArticle);

	  @GetMapping(value = APP_ROOT + "/articles/all", produces = MediaType.APPLICATION_JSON_VALUE)
	  
	  List<ArticleDto> findAll();

	  @GetMapping(value = APP_ROOT + "/articles/historique/vente/{idArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
	  List<LigneVenteDto> findHistoriqueVentes(@PathVariable("idArticle") Integer idArticle);

	  @GetMapping(value = APP_ROOT + "/articles/historique/commandeclient/{idArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
	  List<LigneCommandeClientDto> findHistoriaueCommandeClient(@PathVariable("idArticle") Integer idArticle);

	  @GetMapping(value = APP_ROOT + "/articles/historique/commandefournisseur/{idArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
	  List<LigneCommandeFournisseurDto> findHistoriqueCommandeFournisseur(@PathVariable("idArticle") Integer idArticle);

	  @GetMapping(value = APP_ROOT + "/articles/filter/category/{idCategory}", produces = MediaType.APPLICATION_JSON_VALUE)
	  List<ArticleDto> findAllArticleByIdCategory(@PathVariable("idCategory") Integer idCategory);

	  @DeleteMapping(value = APP_ROOT + "/articles/delete/{idArticle}")
	 
	  void delete(@PathVariable("idArticle") Integer id);

}
