package es.fpsumma.dam2.utilidades.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// Esta clase representa una "fila" de la tabla "tareas" en la base de datos.
// Room la convierte en una tabla SQLite gracias a @Entity.
@Entity(tableName = "asignaturas")
data class Asignaturas(

    // Clave primaria (identificador único) de cada tarea.
    // autoGenerate = true => Room genera el id automáticamente al insertar.
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    // Columna de la tabla donde guardamos el título.
    // name = nombre real de la columna en la BD (puede ser distinto al nombre del atributo).
    @ColumnInfo(name = "asignatura")
    val asignatura: String,

    // Columna de la tabla donde guardamos la descripción.
    @ColumnInfo(name = "trimestre")
    val trimestre: String,

    @ColumnInfo(name = "nota", defaultValue = "1")
    val nota: Int = 1,
)