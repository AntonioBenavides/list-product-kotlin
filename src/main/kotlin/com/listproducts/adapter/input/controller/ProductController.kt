package com.listproducts.adapter.input.controller

import com.listproducts.domain.model.Product
import com.listproducts.domain.port.input.ProductUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin(origins = ["*"])
@RequestMapping("/api/products")
class ProductController(
    private val useCase: ProductUseCase
) {
    @GetMapping("/all")
//  Busca todos os produtos, não requer dados de entrada
    fun getAllProducts(): ResponseEntity<List<Product>> {
        return try {
            val products = useCase.fetchAll()
            ResponseEntity.ok(products)
        } catch (e: Exception) {
            ResponseEntity.internalServerError().build()
        }
    }
//  Busca uma lista de produtos, exige recebimento de uma lista de IDs
    @GetMapping("/by-ids")
    fun getProductsByIds(@RequestBody ids: List<String>): ResponseEntity<List<Product>> {
        return try {
            val products = useCase.fetchByIds(ids)
            ResponseEntity.ok(products)
        } catch (e: Exception) {
            ResponseEntity.internalServerError().build()
        }
    }
}