package com.example.layoutscompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.layoutscompose.ui.*

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppMenu()
        }
    }
}

@Composable
fun AppMenu() {

    var screen by remember { mutableStateOf("menu") }

    when (screen) {

        "menu" -> {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFECECEC))
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Text(
                    text = "Menu do Aplicativo",
                    fontSize = 30.sp
                )

                Spacer(modifier = Modifier.height(30.dp))

                Row {

                    MenuButton("Login") { screen = "login" }

                    Spacer(modifier = Modifier.width(16.dp))

                    MenuButton("Formulário") { screen = "form" }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Row {

                    MenuButton("Tarefas") { screen = "tasks" }

                    Spacer(modifier = Modifier.width(16.dp))

                    MenuButton("Filmes") { screen = "movies" }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Row {

                    MenuButton("Categorias") { screen = "categories" }

                    Spacer(modifier = Modifier.width(16.dp))

                    MenuButton("Cores") { screen = "color" }
                }

                Spacer(modifier = Modifier.height(16.dp))

                MenuButton("Viagens") { screen = "travel" }

            }
        }

        "login" -> LoginScreen { screen = "menu" }

        "form" -> FormScreen { screen = "menu" }

        "tasks" -> TaskScreen { screen = "menu" }

        "movies" -> MovieScreen { screen = "menu" }

        "categories" -> CategoriesScreen { screen = "menu" }

        "color" -> ColorLayoutScreen { screen = "menu" }

        "travel" -> TravelScreen { screen = "menu" }
    }
}

@Composable
fun MenuButton(texto: String, onClick: () -> Unit) {

    Button(
        onClick = onClick,
        modifier = Modifier
            .width(150.dp)
            .height(60.dp)
    ) {

        Text(texto)
    }
}