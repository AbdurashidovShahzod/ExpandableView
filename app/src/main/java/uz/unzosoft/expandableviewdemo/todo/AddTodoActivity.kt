package uz.unzosoft.expandableviewdemo.todo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_todo.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main_todo.*
import kotlinx.android.synthetic.main.activity_second.*
import uz.unzosoft.expandableviewdemo.R
import uz.unzosoft.expandableviewdemo.adapters.MyExpandableTodoAdapter
import uz.unzosoft.expandableviewdemo.ui.ResultActivity1


class AddTodoActivity : AppCompatActivity() {

    lateinit var map: HashMap<String, List<String>>
    var titleList = ArrayList<String>()
    lateinit var todoAdapter: MyExpandableTodoAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_todo)
        initData()
        todoAdapter = MyExpandableTodoAdapter(titleList, map)
        expandableListViewTodo?.setAdapter(todoAdapter)


    }

    private fun initData() {
        map = HashMap()
        val todoList = arrayListOf("Urgent", "High", "Normal", "Low")
        map["To do degree"] = todoList
        titleList.add("To do degree")


    }

}
