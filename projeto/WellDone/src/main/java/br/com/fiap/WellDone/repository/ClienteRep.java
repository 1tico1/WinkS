package br.com.fiap.WellDone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.WellDone.model.Cliente;

@Repository
public interface ClienteRep extends JpaRepository<Cliente, Long> {
	
	List<Cliente> findAll();
	Cliente findById(long id);   
    void deleteById(long id);
    
}
