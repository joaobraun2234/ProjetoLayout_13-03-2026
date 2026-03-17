package com.example.layoutscompose.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MovieScreen(onBack: () -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Card(
                modifier = Modifier.size(90.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xFFD1C4E9)),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Livro")
                }
            }

            Spacer(modifier = Modifier.width(15.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = "O Bicho-da-Seda",
                    fontSize = 20.sp
                )

                Text(
                    text = "Autor: Robert Galbraith",
                    color = Color.Gray
                )

                Text(
                    text = "Data: 19 Jun 2014",
                    color = Color.Gray
                )
            }

            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF6A1B9A)
                )
            ) {
                Text("LER", color = Color.White)
            }
        }

        Spacer(modifier = Modifier.height(25.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {

            Column(horizontalAlignment = Alignment.CenterHorizontally) {

                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .background(Color(0xFF7E57C2), CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Text("4.0", color = Color.White)
                }

                Text("Avaliação")
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally) {

                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .background(Color(0xFF7E57C2), CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(Icons.Default.Search, null, tint = Color.White)
                }

                Text("Buscar")
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally) {

                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .background(Color(0xFF7E57C2), CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(Icons.Default.ThumbUp, null, tint = Color.White)
                }

                Text("Curtir")
            }
        }

        Spacer(modifier = Modifier.height(25.dp))

        Text(
            text = "O detetive particular Cormoran Strike retorna em um novo mistério. Uma história envolvente escrita por Robert Galbraith, autor do famoso best-seller internacional.",
            fontSize = 14.sp
        )

        Spacer(modifier = Modifier.height(15.dp))

        Text(
            text = "LER MAIS",
            color = Color(0xFF6A1B9A)
        )

        Spacer(modifier = Modifier.height(25.dp))

        Button(
            onClick = { onBack() },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF6A1B9A)
            )
        ) {
            Text("Voltar ao Menu", color = Color.White)
        }
    }
}