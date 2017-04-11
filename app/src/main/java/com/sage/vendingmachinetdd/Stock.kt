package com.sage.vendingmachinetdd

data class Stock(val products: ArrayList<Product>) {
    fun contains(product: Product): Boolean {
        return products.contains(product)
    }
}