package com.example.game2d

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import com.example.game2d.ui.theme.Game2DTheme
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.delay


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Game2DTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val game = Game(GlobalScope)
                    Start(m=Modifier.padding(innerPadding),game )
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE)

                }
            }
        }
    }
}

@Composable
fun Start(m: Modifier,game:Game){
    var counter by remember { mutableStateOf(0) }
    var counter2 by remember { mutableStateOf(0) }
    Row {
        Button(
            onClick = {
                GlobalScope.launch{
                    counter = 0
                    while (counter<100 ){
                        delay(1000)
                        counter++
                    }
                }

                if (counter<40){
                    counter ++
                }
            },
            modifier = m
        ) {
            Text(text = "開始")
        }

        Text(text = counter.toString(), modifier = m)

        Button(
            onClick = {
                counter2++
            },
            modifier = m
        ) {
            Text(text="加1")
        }
           Text(text=counter2.toString(), modifier = m)
    }

}
