package uz.unzosoft.expandableviewdemo.todo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main_todo.*
import uz.unzosoft.expandableviewdemo.R

class MainTodoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_todo)
        addToDoButton.setOnClickListener {
            startActivity(Intent(this, AddTodoActivity::class.java))
        }

    }
}