package com.listproducts.domain.port.input

import com.listproducts.domain.model.Product

interface ProductUseCase {
    fun fetchAll(): List<Product>
    fun fetchByIds(ids: List<String>): List<Product>
}
