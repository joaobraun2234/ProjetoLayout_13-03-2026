package com.example.layoutscompose.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TaskScreen(onBack: () -> Unit) {

    var titulo by remember { mutableStateOf("") }
    var status by remember { mutableStateOf("Não Concluído") }
    var prioridade by remember { mutableStateOf("Média") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFECECEC))
            .padding(16.dp)
    ) {

        Text("Título", fontSize = 20.sp)

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = titulo,
            onValueChange = { titulo = it },
            placeholder = { Text("Digite o título") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text("Status", fontSize = 18.sp)

        Row {

            RadioButton(
                selected = status == "Concluído",
                onClick = { status = "Concluído" }
            )

            Text("Concluído")

            Spacer(modifier = Modifier.width(20.dp))

            RadioButton(
                selected = status == "Não Concluído",
                onClick = { status = "Não Concluído" }
            )

            Text("Não Concluído")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text("Prioridade", fontSize = 18.sp)

        Row {

            RadioButton(
                selected = prioridade == "Baixa",
                onClick = { prioridade = "Baixa" }
            )

            Text("Baixa")

            Spacer(modifier = Modifier.width(20.dp))

            RadioButton(
                selected = prioridade == "Média",
                onClick = { prioridade = "Média" }
            )

            Text("Média")

            Spacer(modifier = Modifier.width(20.dp))

            RadioButton(
                selected = prioridade == "Alta",
                onClick = { prioridade = "Alta" }
            )

            Text("Alta")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text("Data e Hora", fontSize = 18.sp)

        Spacer(modifier = Modifier.height(10.dp))

        Row {

            Button(onClick = { }) {
                Text("Escolher Data")
            }

            Spacer(modifier = Modifier.width(10.dp))

            Button(onClick = { }) {
                Text("Escolher Hora")
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {

            Button(onClick = { onBack() }) {
                Text("Cancelar")
            }

            Button(onClick = { }) {
                Text("Resetar")
            }

            Button(onClick = { }) {
                Text("Enviar")
            }
        }
    }
}