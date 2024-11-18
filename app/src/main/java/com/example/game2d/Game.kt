package com.example.game2d

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow

class Game (val scope:CoroutineScope,val screenW:Int, val screenH: Int){
    var counter = 0
    val state = MutableStateFlow(0)
    val background = Background(screenW)

    fun Play(){
        scope.launch {
            counter = 0
            while (counter<2000) {
                delay(4)
                background.Roll()
                counter++
                state.emit(counter)

            }
        }
    }

}