package com.example.recyclertest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val todoList = mutableListOf(
            Todo("Text", false),
            Todo("Eat some food", true)
        )

        // This was added
        val rv = findViewById<View>(R.id.rvTodos) as RecyclerView
        val btnAddTodo = findViewById<View>(R.id.btnAddTodo) as Button
        val etTodo = findViewById<View>(R.id.etTodo) as TextView

        val adapter = TodoAdapter(todoList)
        rv.adapter = adapter
        rv.layoutManager = LinearLayoutManager(this)

        btnAddTodo.setOnClickListener {
            val title = etTodo.text.toString()
            val todo = Todo(title, false)
            todoList.add(todo)
            adapter.notifyItemInserted(todoList.size - 1)
        }

    }
}