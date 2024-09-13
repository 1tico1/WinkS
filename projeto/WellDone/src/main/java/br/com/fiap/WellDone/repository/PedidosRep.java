package br.com.fiap.WellDone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.WellDone.model.Pedido;

@Repository
public interface PedidosRep extends JpaRepository<Pedido, Long> {

	List<Pedido> findAll();
	Pedido findById(long id);
    void deleteById(long id);
}
