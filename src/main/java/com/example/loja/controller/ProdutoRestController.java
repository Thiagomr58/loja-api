package com.example.loja.controller;

import com.example.loja.model.Produto;
import com.example.loja.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

/**
 * Created by Thiago Rodrigues on 14/02/2020
 */
@RestController
@RequestMapping("/produtos")
public class ProdutoRestController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Produto> listar() { return produtoService.listAll(); }

    @PostMapping
    public ResponseEntity<Produto> cadastrar (@Valid @RequestBody Produto produto){
        Produto produtoSalvo = produtoService.save(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoSalvo);
    }


    @PutMapping("/{id}/imagem")
    public ResponseEntity<Produto> imagemProduto(@PathVariable Long id, @RequestParam("photo") MultipartFile file) throws IOException {
        byte[] photoByte = file.getBytes();
         produtoService.executaProcedure(id, photoByte);
        return ResponseEntity.ok().build();
}

}
