package com.example.lojaapi.repository;

import com.example.lojaapi.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by Thiago Rodrigues on 14/02/2020
 */
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Query("select new com.example.lojaapi.model.Pedido(p.id, p.dataPedido, p.produto.id, p.produto.descricao, p.quantidade, p.produto.valorUnitario, p.total) from Pedido p")
    List<Pedido> findAllToList();

}
