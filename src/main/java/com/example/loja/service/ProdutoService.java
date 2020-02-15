package com.example.loja.service;

import com.example.loja.model.Produto;
import com.example.loja.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;
import java.util.Optional;

/**
 * Created by Thiago Rodrigues on 14/02/2020
 */
@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public Produto save(Produto produto){
        return produtoRepository.save(produto);
    }
    public List<Produto> listAll() { return produtoRepository.findAll(); }
    public Optional<Produto> findOne(Long id) { return produtoRepository.findById(id); }

    public void executaProcedure(Long id, byte[] foto) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("salvar_foto");

        query.registerStoredProcedureParameter(1, Long.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(2, byte[].class, ParameterMode.IN);

        query.setParameter(1, id);
        query.setParameter(2, foto);

        query.execute();
    }

}
