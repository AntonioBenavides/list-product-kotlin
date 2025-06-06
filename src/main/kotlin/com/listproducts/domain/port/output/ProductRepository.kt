package com.listproducts.domain.port.output

import com.listproducts.domain.model.Product

interface ProductRepository {
    fun getAllProducts(): List<Product>
}