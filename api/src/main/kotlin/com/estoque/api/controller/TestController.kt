package com.estoque.api.controller

import com.estoque.api.model.Produto
import com.estoque.api.services.ProdutoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController(@Autowired val produtoService: ProdutoService) {

    @GetMapping("/test")
    fun listProduto(): ResponseEntity<List<Produto>> {
        return ResponseEntity.ok(produtoService.listAllService())
    }
}