package com.listproducts.application.usecase

import com.listproducts.domain.model.Product
import com.listproducts.domain.port.input.ProductUseCase
import com.listproducts.domain.port.output.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductUseCase(
    private val productRepository: ProductRepository
) : ProductUseCase {
//  Lista todos os produtos
    override fun fetchAll(): List<Product> = productRepository.getAllProducts()
//  Lista os produtos enviados em array por ID
    override fun fetchByIds(ids: List<String>): List<Product> {
        return productRepository.getAllProducts().filter { it.id in ids }
    }
}

