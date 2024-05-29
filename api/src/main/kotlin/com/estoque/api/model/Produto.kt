package com.estoque.api.model

import jakarta.persistence.*
import org.postgresql.shaded.com.ongres.scram.common.bouncycastle.pbkdf2.Integers

@Entity
@Table(name = "produtos")
data class Produto(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    var nome: String = "",
    var qtd_est: Int? = 0,
    var est_min: Int? = 0,
    var qtd_new: Int? = 0,
    var qtd_usd: Int? = 0,
    var descricao: String? = "",
    var tipo_id: Int? = 0,
    var marca: String? = ""
)  {
    // Construtor secundário sem argumentos necessário para o JPA/Hibernate
    constructor() : this(null)
}