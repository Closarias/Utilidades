package es.fpsumma.dam2.utilidades.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import es.fpsumma.dam2.utilidades.model.Asignaturas

// Esto le dice a Room: “esta es mi base de datos”
// - entities: qué tablas tendrá (aquí, la tabla Tarea)
// - version: versión del esquema (si cambias campos/tabla, suele subir)
// - exportSchema=false: no guarda el “historial” del esquema en archivos
@Database(entities = [Asignaturas::class], version = 1, exportSchema = false)

abstract class AppDatabase : RoomDatabase() {
    abstract fun asignaturaDao(): AsignaturaDao

    companion object {
        @Volatile
        private var Instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "asignaturas"
                ).fallbackToDestructiveMigration(false)
                    .build()
                    .also { Instance = it }
            }
        }
    }
}