package es.fpsumma.dam2.utilidades.data.local

import androidx.room.Dao
import androidx.room.Insert


// @Dao indica que esta interfaz es un DAO de Room:
// aquí declaramos las operaciones típicas para la tabla "tareas".
@Dao
interface AsignaturaDao {

    @Insert(onConflict = onConflictStrategy.IGNORE)
    suspend fun insert(asignatura: Asignatura)

    

}