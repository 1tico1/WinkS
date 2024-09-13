package br.com.fiap.WellDone.model;

import org.springframework.hateoas.RepresentationModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "PEDIDO") // Verifique se o nome da tabela está em maiúsculas no banco
public class Pedido extends RepresentationModel<Pedido> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pedido_seq")
    @SequenceGenerator(name = "pedido_seq", sequenceName = "PEDIDO_SEQ", allocationSize = 1)
    private Long pedido_id;

    @Column(name = "PEDIDO_STATUS", nullable = false, length = 50)
    private String pedido_status;

    @Column(name = "PEDIDO_DATA")
    private Date pedido_data;

    @Column(name = "PEDIDO_CLIENTE_ID")
    private Long pedido_cliente_id;

    @Column(name = "PEDIDO_VLR_TOTAL")
    private BigDecimal pedido_vlr_total;

    @Column(name = "PEDIDO_QTD") // Adicionando a nova coluna para a quantidade
    private Integer pedido_qtd;

    public Pedido() {}

    public Pedido(Long pedido_id, String pedido_status, Date pedido_data, Long pedido_cliente_id, BigDecimal pedido_vlr_total, Integer pedido_qtd) {
        this.pedido_id = pedido_id;
        this.pedido_status = pedido_status;
        this.pedido_data = pedido_data;
        this.pedido_cliente_id = pedido_cliente_id;
        this.pedido_vlr_total = pedido_vlr_total;
        this.pedido_qtd = pedido_qtd;
    }

    // Getters e Setters
    public Long getPedido_id() {
        return pedido_id;
    }

    public void setPedido_id(Long pedido_id) {
        this.pedido_id = pedido_id;
    }

    public String getPedido_status() {
        return pedido_status;
    }

    public void setPedido_status(String pedido_status) {
        this.pedido_status = pedido_status;
    }

    public Date getPedido_data() {
        return pedido_data;
    }

    public void setPedido_data(Date pedido_data) {
        this.pedido_data = pedido_data;
    }

    public Long getPedido_cliente_id() {
        return pedido_cliente_id;
    }

    public void setPedido_cliente_id(Long pedido_cliente_id) {
        this.pedido_cliente_id = pedido_cliente_id;
    }

    public BigDecimal getPedido_vlr_total() {
        return pedido_vlr_total;
    }

    public void setPedido_vlr_total(BigDecimal pedido_vlr_total) {
        this.pedido_vlr_total = pedido_vlr_total;
    }

    public Integer getPedido_qtd() {
        return pedido_qtd;
    }

    public void setPedido_qtd(Integer pedido_qtd) {
        this.pedido_qtd = pedido_qtd;
    }
}
