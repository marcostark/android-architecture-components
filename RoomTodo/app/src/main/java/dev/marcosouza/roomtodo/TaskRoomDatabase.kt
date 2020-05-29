package dev.marcosouza.roomtodo

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

/** exportSchema como false para evitar aviso de construção das migrações */
@Database(entities = [Task::class], version = 1, exportSchema = false)
public abstract class TaskRoomDatabase: RoomDatabase() {

    abstract fun taskDao(): TaskDao

    companion object {

        @Volatile
        private var INSTANCE: TaskRoomDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): TaskRoomDatabase {
            val tempIntance = INSTANCE
            if(tempIntance != null) {
                return tempIntance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TaskRoomDatabase::class.java,
                    "task_database"
                ).addCallback(TaskDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }

    private class TaskDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let { database ->
                scope.launch {
                    populateDatabase(database.taskDao())
                }
            }
        }

        suspend fun populateDatabase(taskDao: TaskDao) {
            // Remove todas as tarefas armazenadas no banco de dados
            taskDao.deleteAll()

            // Popula o banco com algumas tarefas cadastradas

            var task = Task("Estudar Android Compoenents Architeture")
            taskDao.insert(task)
            task = Task("Continue estudando...")
            taskDao.insert(task)
        }
    }
}

