package com.example.todo


import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "MainActivity"
    }

    @SuppressLint("ResourceType")
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.layout.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_add_task -> {
                return true
            }
            R.id.menu_delete_tasks -> {
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate called")


        val tasks = TaskManager.getTasks()

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, tasks)

        val listView: ListView = findViewById(R.id.listView)
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            val selectedTask = tasks[position]

            if (!selectedTask.getYoutubeLink().isNullOrEmpty()) {
                val youtubeLink = selectedTask.getYoutubeLink()
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(youtubeLink))
                startActivity(intent)

                tasks.remove(selectedTask)

                adapter.notifyDataSetChanged()

                showSnackbar("Otwarto link do YouTube: ${selectedTask.title}")
            } else {
                TaskManager.markTaskAsCompleted(selectedTask)

                adapter.notifyDataSetChanged()

                showSnackbar("Zadanie wykonane i usunięte: ${selectedTask.title}")
            }
        }


        val addTaskButton: Button = findViewById(R.id.addTaskButton)
        val taskNameEditText: EditText = findViewById(R.id.taskNameEditText)

        addTaskButton.setOnClickListener {
            val taskName = taskNameEditText.text.toString().trim()

            if (taskName.isNotEmpty()) {
                val newTask = Task(taskName.toUpperCase())
                tasks.add(newTask)

                adapter.notifyDataSetChanged()

                showSnackbar("Dodano nowe zadanie: $taskName")

                taskNameEditText.text.clear()
            } else {
                showSnackbar("Nazwa zadania nie może być pusta!")
            }
        }
    }
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy called")
    }

    private fun showSnackbar(message: String) {
        val rootView: View = findViewById(android.R.id.content)
        Snackbar.make(rootView, message, Snackbar.LENGTH_SHORT).show() }
}