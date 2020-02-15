package com.example.lojaapi.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Created by Thiago Rodrigues on 14/02/2020
 */
@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_produto", referencedColumnName = "id", nullable = false)
    private Produto produto;

    @Column(name = "data_pedido",  nullable = false)
    private LocalDate dataPedido;

    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;

    @Column(name = "total")
    private BigDecimal total;

    public Pedido() {
    }

    public Pedido(Long id, LocalDate dataPedido, Long idProduto, String descricaoProduto, Integer quantidade, BigDecimal valorUnitario, BigDecimal total) {
        this.id = id;
        this.dataPedido = dataPedido;
        this.quantidade = quantidade;
        this.produto = new Produto(idProduto, descricaoProduto, valorUnitario);
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(id, pedido.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
