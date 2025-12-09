package es.fpsumma.dam2.utilidades.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import es.fpsumma.dam2.utilidades.data.local.AppDatabase
import es.fpsumma.dam2.utilidades.model.Asignaturas
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class AsignaturasViewModel(app: Application) : AndroidViewModel(app) {

    private val db = Room.databaseBuilder(
        app, AppDatabase::class.java, "asignaturas.db"
    ).fallbackToDestructiveMigration(false).build()

    private val dao = db.asignaturaDao()

    val asignaturas: StateFlow<List<Asignaturas>> =
        dao.getAllAsignaturas().stateIn(
            viewModelScope,
            SharingStarted.Lazily,
            emptyList()
        )

    fun addAsignatura(asignatura: String, trimestre: String, nota: Int) = viewModelScope.launch {
        dao.insert(Asignaturas(asignatura = asignatura, trimestre = trimestre, nota = nota))
    }

    fun deleteAsignatura(asignaturas: Asignaturas) = viewModelScope.launch {
        dao.delete(asignaturas)
    }
}