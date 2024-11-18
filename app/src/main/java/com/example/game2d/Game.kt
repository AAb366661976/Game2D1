package com.example.game2d

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class Game (val scope:CoroutineScope){
    var counter = 0
    fun Play(){
        scope.launch {
            counter = 0
            while (counter<10) {
                delay(1000)
                counter++
            }
        }
    }

}