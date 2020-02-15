package com.example.lojaapi.service;

import com.example.lojaapi.model.Pedido;
import com.example.lojaapi.model.Produto;
import com.example.lojaapi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * Created by Thiago Rodrigues on 14/02/2020
 */
@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProdutoService produtoService;

    public Pedido salvar(Pedido pedido){

        Produto produtoVinculado = produtoService.findOne(pedido.getProduto().getId()).get();
        pedido.setTotal(this.calculaTotal(pedido.getQuantidade(), produtoVinculado.getValorUnitario()));
        return pedidoRepository.save(pedido);
    }

    public List<Pedido> listAll(){
        return pedidoRepository.findAllToList();
    }

    private BigDecimal calculaTotal(Integer qtd, BigDecimal valorUnitario){
        return valorUnitario.multiply(BigDecimal.valueOf(qtd.longValue()));

    }

}
