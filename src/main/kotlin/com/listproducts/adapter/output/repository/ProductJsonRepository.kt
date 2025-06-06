package com.listproducts.adapter.output.repository

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.listproducts.domain.model.Product
import com.listproducts.domain.port.output.ProductRepository
import org.springframework.core.io.ClassPathResource
import org.springframework.stereotype.Repository

@Repository
class ProductJsonRepository(
    private val objectMapper: ObjectMapper
) : ProductRepository {

    override fun getAllProducts(): List<Product> {
//  Acessa o arquivo Json e cria um array de produtos
        return try {
            val inputStream = ClassPathResource("products.json").inputStream
            objectMapper.readValue(inputStream, object : TypeReference<List<Product>>() {})
        } catch (e: Exception) {
            throw RuntimeException("Erro ao ler arquivo JSON", e)
        }
    }
}