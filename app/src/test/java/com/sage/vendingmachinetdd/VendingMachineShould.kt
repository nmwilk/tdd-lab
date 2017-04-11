package com.sage.vendingmachinetdd

import org.hamcrest.CoreMatchers.equalTo
import org.junit.Assert
import org.junit.Test

/**
 * Created by neil.wilkinson on 11/04/2017.
 */
class VendingMachineShould {
    private var vm = VendingMachine(Stock(arrayListOf(Product("Water", 1, 100), Product("Chocolate", 1, 50))))

    @Test
    fun accepts_one_pound_coin() {
        vm.addCoin(Coin(100))

        Assert.assertThat(vm.amountEntered(), equalTo(100))
    }

    @Test
    fun vend_an_item_when_enough_money_inserted() {
        vm.addCoin(Coin(100))
        vm.selectItem(Product("Water", 1, 100))

        Assert.assertThat(vm.itemsVended(), equalTo(1))
    }

    @Test
    fun vend_other_item() {
        vm.addCoin(Coin(50))
        vm.selectItem(Product("Chocolate", 1, 50))

        Assert.assertThat(vm.itemsVended(), equalTo(1))
    }

    @Test
    fun dont_vend_an_item_when_not_enough_money_inserted() {
        vm.addCoin(Coin(10))
        vm.selectItem(Product("Water", 1, 100))

        Assert.assertThat(vm.itemsVended(), equalTo(0))
    }

    @Test
    fun dont_vend_an_item_when_not_enough_stock() {
        val vm = VendingMachine(Stock(arrayListOf(Product("Chocolate", 1, 100))))
        vm.addCoin(Coin(100))
        vm.selectItem(Product("Water", 1, 100))

        Assert.assertThat(vm.itemsVended(), equalTo(0))
    }

    @Test
    fun change_returned() {
        vm.addCoin(Coin(100))
        vm.addCoin(Coin(10))
        vm.selectItem(Product("Water", 1, 100))

        Assert.assertThat(vm.changeReturned(), equalTo(10))
    }
}

