package situacao.de.aprendizagem4.senaiUC9.SituacaoDeAprendizagem4_UC09.services;

import java.util.List;

import situacao.de.aprendizagem4.senaiUC9.SituacaoDeAprendizagem4_UC09.orm.Biblioteca;

public interface BibliotecaServico {
	
	//Read - Ler
	public List<Biblioteca> listarLivros();
	
	//Create - Criar
	public Biblioteca salvarLivros(Biblioteca biblioteca);
	
	//Delete - Deletar
	public void apagarLivro(Integer id);
	
	//Upadate - Atualizar
	public Biblioteca consultarLivrosId(Integer id);
	
	public Biblioteca atualizarLivro(Biblioteca biblioteca);
}
