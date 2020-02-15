package com.example.loja.repository;

import com.example.loja.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Thiago Rodrigues on 14/02/2020
 */
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query("select new com.example.loja.model.Produto(p.id, p.descricao, p.valorUnitario) from Produto p")
    List<Produto> findAllToList();
}
