package es.fpsumma.dam2.utilidades.ui.screens.tareas

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import es.fpsumma.dam2.utilidades.ui.navigation.Routes
import es.fpsumma.dam2.utilidades.ui.viewmodel.AsignaturasViewModel


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ListadoTareasScreen(navController: NavController, vm: AsignaturasViewModel, modifier: Modifier= Modifier) {

    val asignaturas by vm.asignaturas.collectAsState()

    /**fun handleAddTarea(){
        vm.addAsignatura()
        titulo=""
        descripcion=""
    }**/

    /**fun handleDeleteTarea(tarea: Tarea){
        vm.deleteTarea(tarea)
    }**/

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Agregar asignaturas") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate(Routes.HOME) }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Volver")
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)) {

            LazyColumn(
                modifier = modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {

                items(
                    items = asignaturas,
                    key = { it.id }
                ) { asignatura ->
                    Card (
                        modifier = modifier,

                        shape = RoundedCornerShape(16.dp)
                    ) {
                        ListItem(
                            headlineContent = {
                                Text(
                                    asignatura.asignatura,
                                    fontWeight = FontWeight.Bold
                                )},
                            supportingContent = { Text(asignatura.trimestre) },
                            leadingContent = {
                                Text(
                                    asignatura.nota.toString(),
                                    modifier = modifier.padding(end = 12.dp))},
                            trailingContent = {
                                IconButton(
                                    onClick = {
                                        vm.deleteAsignatura(asignatura)
                                    },
                                    modifier = modifier.size(48.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Outlined.Delete,
                                        contentDescription = "Borrar nota"
                                    )
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}