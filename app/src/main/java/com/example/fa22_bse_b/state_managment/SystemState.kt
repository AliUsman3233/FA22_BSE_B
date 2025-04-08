package com.example.fa22_bse_b.state_managment

import com.example.fa22_bse_b.prodcuts.model.Product

class SystemState {

    var a: Int = 0
    companion object {
        var loginState = false
        var countState = 0
        var playerState = true
        var product: Product? = null
    }

}