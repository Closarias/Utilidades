package es.fpsumma.dam2.utilidades.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import es.fpsumma.dam2.utilidades.ui.screens.home.HomeScreen
import es.fpsumma.dam2.utilidades.ui.screens.tareas.ListadoTareasScreen
import es.fpsumma.dam2.utilidades.ui.viewmodel.AsignaturasViewModel

@Composable
fun AppNavHost(navController: NavHostController, asignaturasViewModel: AsignaturasViewModel) {
    NavHost(navController = navController, startDestination = Routes.HOME) {
        composable(Routes.HOME) { HomeScreen(navController, asignaturasViewModel)}
        composable(Routes.LISTADO_TAREAS) { ListadoTareasScreen(navController,asignaturasViewModel) }

    }
}