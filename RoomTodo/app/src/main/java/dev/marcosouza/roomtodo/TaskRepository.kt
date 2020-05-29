package dev.marcosouza.roomtodo

import androidx.lifecycle.LiveData

class TaskRepository(
    private val taskDao: TaskDao
) {

    val allTasks: LiveData<List<Task>> = taskDao.getAlphabetizedTasks()

    suspend fun insert(task: Task) {
        taskDao.insert(task)
    }
}