package situacao.de.aprendizagem4.senaiUC9.SituacaoDeAprendizagem4_UC09.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import situacao.de.aprendizagem4.senaiUC9.SituacaoDeAprendizagem4_UC09.orm.Biblioteca;

@Repository
public interface Sa3repository extends JpaRepository <Biblioteca, Integer>{
	
}