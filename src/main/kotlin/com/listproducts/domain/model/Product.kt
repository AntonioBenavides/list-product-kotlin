package com.listproducts.domain.model

data class Product(
    val id: String,
    val name: String,
    val imageUrl: String,
    val description: String,
    val price: Double,
    val discount: Int,
    val installments: Int,
    val freeShipping: Boolean,
    val rating: Rating,
    val specs: Specs,
    val vendor: Vendor
)

data class Rating(
    val rate: Double,
    val count: Int
)

data class Specs(
    val battery: String,
    val bluetooth: String,
    val waterproof: String
)

data class Vendor(
    val vendorName: String,
    val vendorCategory: String,
    val vendorSales: Int
)