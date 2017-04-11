package com.sage.vendingmachinetdd

class VendingMachine(private var stock: Stock) {
    var amountEntered = 0
    var changeReturned = 0
    var itemsVended = 0

    fun addCoin(coin: Coin) {
        amountEntered += coin.amount
    }

    fun amountEntered(): Int {

        return amountEntered
    }

    fun itemsVended(): Int {
        return itemsVended
    }

    fun selectItem(product: Product) {
        if (stock.contains(product) && amountEntered >= product.price) {
            changeReturned = amountEntered - product.price
            ++itemsVended
        }
    }

    fun changeReturned(): Int {
        return changeReturned
    }
}

