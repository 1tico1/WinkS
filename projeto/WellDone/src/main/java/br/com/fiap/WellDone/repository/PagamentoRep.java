package br.com.fiap.WellDone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.WellDone.model.Pagamento;

@Repository
public interface PagamentoRep extends JpaRepository<Pagamento, Long>{
	
	List<Pagamento> findAll();
	Pagamento findById(long id);   
    void deleteById(long id);
}
