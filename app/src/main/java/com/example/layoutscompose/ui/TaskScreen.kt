package com.example.layoutscompose.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.layoutscompose.Model.TaskViewModel

@Composable
fun TaskScreen(
    onBack: () -> Unit,
    viewModel: TaskViewModel = viewModel()
) {

    val titulo by viewModel.titulo.collectAsState()
    val status by viewModel.status.collectAsState()
    val prioridade by viewModel.prioridade.collectAsState()
    val date by viewModel.date.collectAsState()
    val time by viewModel.time.collectAsState()

    var showDatePicker by remember { mutableStateOf(false) }
    var showTimePicker by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFECECEC))
            .padding(16.dp)
    ) {

        Text("Título", fontSize = 20.sp)

        OutlinedTextField(
            value = titulo,
            onValueChange = { viewModel.updateTitulo(it) },
            placeholder = { Text("Digite o título") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text("Status", fontSize = 18.sp)

        Row {
            RadioButton(
                selected = status == "Concluído",
                onClick = { viewModel.updateStatus("Concluído") }
            )
            Text("Concluído")

            Spacer(modifier = Modifier.width(20.dp))

            RadioButton(
                selected = status == "Não Concluído",
                onClick = { viewModel.updateStatus("Não Concluído") }
            )
            Text("Não Concluído")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text("Prioridade", fontSize = 18.sp)

        Row {
            RadioButton(
                selected = prioridade == "Baixa",
                onClick = { viewModel.updatePrioridade("Baixa") }
            )
            Text("Baixa")

            Spacer(modifier = Modifier.width(20.dp))

            RadioButton(
                selected = prioridade == "Média",
                onClick = { viewModel.updatePrioridade("Média") }
            )
            Text("Média")

            Spacer(modifier = Modifier.width(20.dp))

            RadioButton(
                selected = prioridade == "Alta",
                onClick = { viewModel.updatePrioridade("Alta") }
            )
            Text("Alta")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text("Data e Hora", fontSize = 18.sp)

        Text("Data: $date")
        Text("Hora: $time")

        Row {
            Button(onClick = { showDatePicker = true }) {
                Text("Escolher Data")
            }

            Spacer(modifier = Modifier.width(10.dp))

            Button(onClick = { showTimePicker = true }) {
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

            Button(onClick = { viewModel.reset() }) {
                Text("Resetar")
            }

            Button(onClick = { }) {
                Text("Enviar")
            }
        }
    }

    // DATE PICKER e TIME PICKER continuam iguais
}