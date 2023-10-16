package situacao.de.aprendizagem4.senaiUC9.SituacaoDeAprendizagem4_UC09.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import situacao.de.aprendizagem4.senaiUC9.SituacaoDeAprendizagem4_UC09.orm.Biblioteca;
import situacao.de.aprendizagem4.senaiUC9.SituacaoDeAprendizagem4_UC09.repository.Sa3repository;

@Service
public class BibliotecaServicoCRUD implements BibliotecaServico{
	@Autowired
	private Sa3repository repositorio;
	
	//Read - Ler
	@Override
	public List<Biblioteca> listarLivros(){
		return repositorio.findAll();
	}
	
	//Create - Criar
	@Override
	public Biblioteca salvarLivros(Biblioteca biblioteca) {
		return repositorio.save(biblioteca);
	}
	
	//Delete - Deletar
	@Override
	public void apagarLivro(Integer id) {
		repositorio.deleteById(id);
	}
	
	//Upadate - Atualizar
	@Override
	public Biblioteca consultarLivrosId(Integer id) {
		return repositorio.findById(id).get();
	}
	
	@Override
	public Biblioteca atualizarLivro(Biblioteca biblioteca) {
		return repositorio.save(biblioteca);
	}
}