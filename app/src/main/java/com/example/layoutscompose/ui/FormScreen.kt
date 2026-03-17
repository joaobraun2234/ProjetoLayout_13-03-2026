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
fun FormScreen(onBack: () -> Unit) {

    var nome by remember { mutableStateOf("") }
    var sobrenome by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFECECEC))
            .padding(20.dp)
    ) {

        Text("Formulário", fontSize = 28.sp)

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = nome,
            onValueChange = { nome = it },
            label = { Text("Nome") }
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = sobrenome,
            onValueChange = { sobrenome = it },
            label = { Text("Sobrenome") }
        )

        Spacer(modifier = Modifier.height(30.dp))

        Button(onClick = {}) {
            Text("Enviar")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = { onBack() }) {
            Text("Voltar")
        }
    }
}