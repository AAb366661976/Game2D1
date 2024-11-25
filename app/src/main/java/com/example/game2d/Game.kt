package com.example.game2d

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow

class Game (val scope:CoroutineScope,val screenW:Int, val screenH: Int,scale: Float){
    var counter = 0
    val state = MutableStateFlow(0)
    val background = Background(screenW)
    var isPlaying = true
    val boy=Boy(screenH,scale)
    val virus = Virus(screenW, screenH, scale)

    fun Play(){
        scope.launch {
            //counter = 0
            isPlaying = true
            while (isPlaying) {
                delay(40)
                background.Roll()

                if (counter%3==0){
                    boy.Walk()
                    virus.Fly()

                }

                counter++
                state.emit(counter)

            }
        }

        if(boy.getRect().intersect(virus.getRect())) {
            isPlaying = false
        }
    }

}

