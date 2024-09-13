package br.com.fiap.WellDone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.WellDone.model.Produto;

@Repository
public interface ProdutoRep extends JpaRepository<Produto, Long>{
	
	List<Produto> findAll();
	 Produto findById(long id);
	 void deleteById(long id);
}
