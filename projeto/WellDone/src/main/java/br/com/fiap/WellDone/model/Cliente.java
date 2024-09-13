package br.com.fiap.WellDone.model;

import org.springframework.hateoas.RepresentationModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente extends RepresentationModel<Cliente> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente_seq")
    @SequenceGenerator(name = "cliente_seq", sequenceName = "CLIENTE_SEQ", allocationSize = 1)
    private Long id_cliente;

    @Column(name = "nome", nullable = false, length = 255)
    private String nome;

    @Column(name = "endereco", length = 255)
    private String endereco;

    @Column(name = "nr_telefone")
    private Long nr_telefone;

    @Column(name = "email", length = 255)
    private String email;

    public Cliente() {}

    public Cliente(Long id_cliente, String nome, String endereco, Long nr_telefone, String email) {
        super();
        this.id_cliente = id_cliente;
        this.nome = nome;
        this.endereco = endereco;
        this.nr_telefone = nr_telefone;
        this.email = email;
    }

    public Long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Long getNr_telefone() {
        return nr_telefone;
    }

    public void setNr_telefone(Long nr_telefone) {
        this.nr_telefone = nr_telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
