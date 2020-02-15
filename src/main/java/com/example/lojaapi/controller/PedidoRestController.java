package com.example.lojaapi.controller;

import com.example.lojaapi.model.Pedido;
import com.example.lojaapi.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Thiago Rodrigues on 14/02/2020
 */
@RestController
@RequestMapping("/pedidos")
public class PedidoRestController {

    @Autowired
    private PedidoService pedidoService;


    @GetMapping
    private List<Pedido> listar(){ return  pedidoService.listAll(); }

    @PostMapping
    private ResponseEntity<Pedido> cadastrar(@Valid @RequestBody Pedido pedido){
        Pedido pedidoSalvo = pedidoService.salvar(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoSalvo);
    }
}
