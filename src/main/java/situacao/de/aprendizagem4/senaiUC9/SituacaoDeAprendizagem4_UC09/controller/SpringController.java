package situacao.de.aprendizagem4.senaiUC9.SituacaoDeAprendizagem4_UC09.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import situacao.de.aprendizagem4.senaiUC9.SituacaoDeAprendizagem4_UC09.orm.Biblioteca;
import situacao.de.aprendizagem4.senaiUC9.SituacaoDeAprendizagem4_UC09.services.BibliotecaServico;

@Controller
public class SpringController {
	@Autowired
	private BibliotecaServico servico;
	
	@GetMapping({"/"})
	public String path() {
		return "index";
	}
	
	//Read - Ler
	@GetMapping({"/livros"})
	public String listarLivros(Model modelo) {
		modelo.addAttribute("biblioteca", servico.listarLivros());
		return "livros";
	}
	
	//Create - Criar
	@GetMapping("/livros/adicionar")
	public String adicionarLivros(Model modelo) {
		Biblioteca objbiblioteca = new Biblioteca();
		modelo.addAttribute("biblioteca", objbiblioteca);
		return "livroform";
	}
	
	@PostMapping("/biblioteca")
	public String salvarLivro(@ModelAttribute("bibliotca") Biblioteca objbiblioteca) {
		servico.salvarLivros(objbiblioteca);
		return "redirect:/livros";
	}
	
	//Delete - Deletar
	@GetMapping({"/biblioteca/{id}"})
	public String apagarLivro(@PathVariable Integer id) {
		servico.apagarLivro(id);
		return "redirect:/livros";
	}
	
	//Update - Atualizar
	@GetMapping({"/biblioteca/editar/{id}"})
	public String editarLivro(@PathVariable Integer id, Model modelo) {
		modelo.addAttribute("biblioteca", servico.consultarLivrosId(id));
		return "editarLivro";
	}
	
	@PostMapping("/biblioteca/{id}")
	public String atualizarLivro(@PathVariable Integer id, @ModelAttribute("biblioteca") Biblioteca biblioteca, Model modelo) {
		Biblioteca cat = servico.consultarLivrosId(id);
		cat.setId(id);
		cat.setTitulo(biblioteca.getTitulo());
		cat.setAutor(biblioteca.getAutor());
		cat.setIsbn(biblioteca.getIsbn());
		cat.setEditora(biblioteca.getEditora());
		servico.atualizarLivro(cat);
		return "redirect:/livros";
	}
}