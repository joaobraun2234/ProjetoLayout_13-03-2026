package com.example.layoutscompose.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.vector.ImageVector

data class Categoria(
    val icon: ImageVector,
    val text: String
)

@Composable
fun CategoriesScreen(onBack: () -> Unit) {

    val categorias = listOf(
        Categoria(Icons.Default.Face, "Woman"),
        Categoria(Icons.Default.Person, "Man"),
        Categoria(Icons.Default.Face, "Baby"),
        Categoria(Icons.Default.LocationOn, "Travel"),
        Categoria(Icons.Default.Call, "Tech"),
        Categoria(Icons.Default.Favorite, "Food&Drink")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF4A148C)) // roxo escuro
    ) {

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.weight(1f)
        ) {

            items(categorias) { categoria ->
                CategoryItem(categoria.icon, categoria.text)
            }
        }

        Button(
            onClick = { onBack() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White
            )
        ) {
            Text(
                text = "Voltar ao Menu",
                color = Color(0xFF4A148C)
            )
        }
    }
}

@Composable
fun CategoryItem(icon: ImageVector, text: String) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .background(Color(0xFF7E57C2)), // roxo claro
        contentAlignment = Alignment.Center
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Icon(
                imageVector = icon,
                contentDescription = text,
                tint = Color.White,
                modifier = Modifier.size(60.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = text,
                color = Color.White,
                fontSize = 18.sp
            )
        }
    }
}