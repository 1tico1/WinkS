package br.com.fiap.WellDone.model;

import java.math.BigDecimal;
import org.springframework.hateoas.RepresentationModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto extends RepresentationModel<Produto> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto_seq")
    @SequenceGenerator(name = "produto_seq", sequenceName = "PRODUTO_SEQ", allocationSize = 1)
    private Long produto_id;

    @Column(name = "produto_nome", nullable = false, length = 255)
    private String produto_nome;

    @Column(name = "produto_descricao", columnDefinition = "TEXT")
    private String produto_descricao;

    @Column(name = "produto_preco", nullable = false, precision = 10, scale = 2)
    private BigDecimal produto_preco;

    @Column(name = "produto_qtd_estoque", nullable = false)
    private Integer produto_qtd_estoque;

    @Column(name = "produto_categoria", nullable = false, length = 255)
    private String produto_categoria;

    @Column(name = "produto_marca", nullable = false, length = 255)
    private String produto_marca;

    public Produto() {}

    public Produto(Long produto_id, String produto_nome, String produto_descricao, BigDecimal produto_preco,
            Integer produto_qtd_estoque, String produto_categoria, String produto_marca) {
        super();
        this.produto_id = produto_id;
        this.produto_nome = produto_nome;
        this.produto_descricao = produto_descricao;
        this.produto_preco = produto_preco;
        this.produto_qtd_estoque = produto_qtd_estoque;
        this.produto_categoria = produto_categoria;
        this.produto_marca = produto_marca;
    }

    public Long getProduto_id() {
        return produto_id;
    }

    public void setProduto_id(Long produto_id) {
        this.produto_id = produto_id;
    }

    public String getProduto_nome() {
        return produto_nome;
    }

    public void setProduto_nome(String produto_nome) {
        this.produto_nome = produto_nome;
    }

    public String getProduto_descricao() {
        return produto_descricao;
    }

    public void setProduto_descricao(String produto_descricao) {
        this.produto_descricao = produto_descricao;
    }

    public BigDecimal getProduto_preco() {
        return produto_preco;
    }

    public void setProduto_preco(BigDecimal produto_preco) {
        this.produto_preco = produto_preco;
    }

    public Integer getProduto_qtd_estoque() {
        return produto_qtd_estoque;
    }

    public void setProduto_qtd_estoque(Integer produto_qtd_estoque) {
        this.produto_qtd_estoque = produto_qtd_estoque;
    }

    public String getProduto_categoria() {
        return produto_categoria;
    }

    public void setProduto_categoria(String produto_categoria) {
        this.produto_categoria = produto_categoria;
    }

    public String getProduto_marca() {
        return produto_marca;
    }

    public void setProduto_marca(String produto_marca) {
        this.produto_marca = produto_marca;
    }
}
