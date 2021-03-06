package br.gov.sp.fatec.springbootapp.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ped_pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ped_id")
    private Long id;

    @Column(name = "ped_nome")
    private String nome;

    @Column(name = "ped_valor")
    private Float valor;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "pedidos")
    private Set<Cliente> clientes;
        
    public Long getId() {
        return this.id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome (String nome) {
        this.nome = nome;
    }   
    
    public Float getValor() {
        return this.valor;
    }

    public void setValor (Float valor) {
        this.valor = valor;
    }    
    
    public Set<Cliente> getClientes() {
        return this.clientes;
    }

    public void setClientes (Set<Cliente> clientes) {
        this.clientes = clientes;
    }  
}