package com.estoque.api.services

import com.estoque.api.model.Produto
import com.estoque.api.repository.ProdutoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProdutoService(@Autowired val produtoRepository: ProdutoRepository) {

    fun listAllService(): List<Produto>{
        return produtoRepository.findAll()
    }

    fun listByIdService(id: Long):Produto?{
        return produtoRepository.findById(id).orElse(null)
    }

    fun saveService(produto: Produto): Produto?{
        return produtoRepository.save(produto)

    }

    fun updateService(id: Long, produto: Produto): Produto?{
        return if (produtoRepository.existsById(id)){
            produtoRepository.save(produto.copy(id = id))
        } else {
            null
        }
    }

    fun deleteService(id: Long){
        if (produtoRepository.existsById(id)){
            produtoRepository.deleteById(id)
        }
    }

}