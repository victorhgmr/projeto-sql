package unip.prj_trab_sql.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unip.prj_trab_sql.produto.Produto;
import unip.prj_trab_sql.produto.ProdutoDTO;
import unip.prj_trab_sql.services.ProdutoService;


import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;
    @PostMapping
    public ResponseEntity<Produto> createProduto(@Valid @RequestBody ProdutoDTO produto){
        Produto newProduto = produtoService.createProduto(produto);
        return new ResponseEntity<>(newProduto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Produto>> getAllProdutos(){
        var produtos = produtoService.getAllProdutos();
        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProduto(@PathVariable("id") Long id){
        this.produtoService.deleteProduto(id);
        return ResponseEntity.ok("resource deleted successfully");
    }

    @PutMapping("{id}")
    public ResponseEntity<Produto> updateProduto(@PathVariable("id") Long id,@Valid @RequestBody Produto produto) throws Exception {
        var upadatedProduto = this.produtoService.updateProduto(id, produto);
        return new ResponseEntity<>(upadatedProduto, HttpStatus.OK );
    }
}
