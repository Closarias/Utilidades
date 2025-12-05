@file:OptIn(ExperimentalMaterial3Api::class)

package es.fpsumma.dam2.utilidades.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import es.fpsumma.dam2.utilidades.ui.viewmodel.AsignaturasViewModel

@Composable
fun HomeScreen(navController: NavController, vm: AsignaturasViewModel, modifier: Modifier= Modifier) {

    var asignatura by rememberSaveable { mutableStateOf("") }
    var trimestre by rememberSaveable { mutableStateOf("") }
    var notaTexto by rememberSaveable { mutableStateOf("") }

    val nota = notaTexto.replace(",", ".").toDoubleOrNull() ?: -1.0

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Asignaturas") }
            )
        }
    ) { innerPadding ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)) {

            OutlinedTextField(
                value = asignatura,
                onValueChange = { asignatura = it },
                label = { Text("Título") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth().padding(4.dp)
            )
            Row (
                modifier = Modifier.padding(4.dp).fillMaxWidth()
            ) {
                FilterChip(
                    selected = trimestre == "primer trimestre",
                    onClick = {trimestre = "primer trimestre"},
                    label = {Text("1º trimestre")},
                    modifier = Modifier.padding(end = 4.dp)
                )
                FilterChip(
                    selected = trimestre == "segundo trimestre",
                    onClick = {trimestre = "segundo trimestre"},
                    label = {Text("2º trimestre")},
                    modifier = Modifier.padding(end = 4.dp)
                )
                FilterChip(
                    selected = trimestre == "tercer trimestre",
                    onClick = {trimestre = "tercer trimestre"},
                    label = {Text("3º trimestre")},
                    modifier = Modifier.padding(end = 4.dp)
                )
            }
            OutlinedTextField(
                value = notaTexto,
                onValueChange = { txt ->
                    notaTexto = txt.filter { it.isDigit() || it == '.' || it == ',' }
                },
                label = { Text("Nota") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth().padding(4.dp)
            )
            Button(
                onClick = {},
                modifier = Modifier.fillMaxWidth()
            ) { "Guardar nota" }
        }
    }
}