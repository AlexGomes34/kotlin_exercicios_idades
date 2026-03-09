package com.example.idades

import android.R.attr.color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.idades.ui.theme.IdadesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IdadesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Idades_maneiras(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


@Composable
fun Idades_maneiras(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var idade by remember{
            mutableStateOf(0)
        }
        var idadeTexto by remember {
            mutableStateOf("")
        }
        Spacer(
            modifier = Modifier
                .size(200.dp)
        )
        Text(text = "Qual é sua idade?", fontSize = 30.sp, color = Color.Blue)
        Text(text = "Aperte os botões para informar a sua idade")
        Spacer(
            modifier = Modifier
                .size(30.dp)
        )
        Text(text = "$idade", fontSize = 80.sp, fontWeight = FontWeight.Thin)
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center

        ) {
            Button(
                modifier = Modifier
                    .size(80.dp),
                shape = RoundedCornerShape(15.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
                onClick = {
                    if (idade == 0) {
                        idade += 0
                    }else {
                        idade -= 1

                        if (idade <18){
                            idadeTexto = "Você é MENOR de idade"
                        }
                    }
                }
            ) {
                Text(text = "-", fontSize = 50.sp)
            }
            Spacer(
                modifier = Modifier
                    .size(30.dp),
            )
            Button(
                modifier = Modifier
                    .size(80.dp),
                shape = RoundedCornerShape(15.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
                onClick = {
                    if (idade == 180){
                        idade -= 1
                    }else{
                        idade += 1
                    }
                    if (idade >= 18){
                        idadeTexto = "Você é MAIOR de idade"
                    }else{
                        idadeTexto = "Você é MENOR de idade"
                    }
                }
            ) {
                Text(text = "+", fontSize = 50.sp)
            }
        }
        Spacer(
            modifier = Modifier
                .size(30.dp),
        )
        Text(text = idadeTexto, color = Color.Blue, fontSize = 30.sp)
    }
}