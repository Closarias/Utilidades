package es.fpsumma.dam2.utilidades.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import es.fpsumma.dam2.utilidades.model.Asignaturas
import kotlinx.coroutines.flow.Flow


// @Dao indica que esta interfaz es un DAO de Room:
// aquí declaramos las operaciones típicas para la tabla "tareas".
@Dao
interface AsignaturaDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(asignaturas: Asignaturas)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAndGetId(asignaturas: Asignaturas): Long

    @Update
    suspend fun update(asignaturas: Asignaturas)

    @Delete
    suspend fun delete(asignaturas: Asignaturas)

    @Query("SELECT * from asignaturas WHERE id = :id")
    fun getAsignatura(id: Int): Flow<Asignaturas>

    @Query("SELECT * from asignaturas ORDER BY asignatura ASC")
    fun getAllAsignaturas(): Flow<List<Asignaturas>>

    @Query("SELECT * FROM asignaturas WHERE id = :id")
    suspend fun getAsignaturaOnce(id: Int): Asignaturas?

    @Query("SELECT COUNT(*) FROM asignaturas")
    fun count(): Flow<Int>

    @Query("SELECT EXISTS(SELECT 1 FROM asignaturas WHERE id = :id)")
    suspend fun exists(id: Int): Boolean

    @Query("SELECT * FROM asignaturas WHERE asignatura LIKE '%' || :texto || '%' ORDER BY asignatura ASC")
    fun searchByAsignatura(texto: String): Flow<List<Asignaturas>>

    @Query("SELECT * FROM asignaturas ORDER BY asignatura ASC LIMIT :limit OFFSET :offset")
    suspend fun getPage(limit: Int, offset: Int): List<Asignaturas>

    @Query("UPDATE asignaturas SET asignatura = :asignatura, trimestre = :trimestre WHERE id = :id")
    suspend fun updateCampos(id: Int, asignatura: String, trimestre: String)

    @Query("DELETE FROM asignaturas")
    suspend fun deleteAll()

    @Query("DELETE FROM asignaturas WHERE id = :id")
    suspend fun deleteById(id: Int)

}