package com.estoque.api.controller

import com.estoque.api.model.Produto
import com.estoque.api.services.ProdutoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class ProdutosController(@Autowired val produtoService: ProdutoService) {

    @GetMapping("/produtos")
    fun listProduto(): ResponseEntity<List<Produto>> {
        return ResponseEntity.ok(produtoService.listAllService())
    }

    @GetMapping("/produtos/{id}")
    fun listById(@PathVariable id: Long): ResponseEntity<Produto> {
        val produto = produtoService.listByIdService(id)
        return if (produto != null) {
            ResponseEntity.ok(produto)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @PostMapping("/produtos")
    fun insertProduto(@RequestBody produto: Produto): ResponseEntity<Produto> {
        val newProduto = produtoService.saveService(produto)
        return ResponseEntity.status(HttpStatus.CREATED).body(newProduto)
    }

    @PutMapping("/produtos/{id}")
    fun updateProduto(@PathVariable id: Long, @RequestBody produto: Produto): ResponseEntity<Produto> {
        val updatedProduto = produtoService.updateService(id, produto)
        return if (updatedProduto != null) {
            ResponseEntity.ok(updatedProduto)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping("/produtos/{id}")
    fun deleteProduto(@PathVariable id: Long): ResponseEntity<Produto> {
        produtoService.deleteService(id)
        return ResponseEntity.noContent().build()
    }
}