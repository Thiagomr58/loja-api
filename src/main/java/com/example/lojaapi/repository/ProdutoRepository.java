package com.example.lojaapi.repository;

import com.example.lojaapi.model.Pedido;
import com.example.lojaapi.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Thiago Rodrigues on 14/02/2020
 */
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query("select new com.example.lojaapi.model.Produto(p.id, p.descricao, p.valorUnitario) from Produto p")
    List<Produto> findAllToList();
}
