package uz.unzosoft.expandableviewdemo.todo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_add_todo.*
import uz.unzosoft.expandableviewdemo.R
import uz.unzosoft.expandableviewdemo.adapters.MyExpandableTodoAdapter

class TestActivity : AppCompatActivity() {

    lateinit var map: HashMap<String, List<String>>
    var titleList = ArrayList<String>()
    lateinit var todoAdapter: MyExpandableTodoAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        initData()
        todoAdapter = MyExpandableTodoAdapter(titleList, map)
        expandableListViewTodo?.setAdapter(todoAdapter)

    }

    private fun initData() {
        map = HashMap()
        val fruitsList = arrayListOf(
            "Apple", "Mango",
            "Banana", "Melon"
        )
        val flowersList = arrayListOf(
            "Atirgul", "Lola",
        )
        val animalsList = arrayListOf("Sher", "Bo'ri", "Quyon")
        val birdsList = arrayListOf("Kaptar", "Kaklik", "Bedana")
        map["Fruits"] = fruitsList
        map["Flowers"] = flowersList
        map["Animals"] = animalsList
        map["Birds"] = birdsList
        titleList.add("Fruits")
        titleList.add("Flowers")
        titleList.add("Animals")
        titleList.add("Birds")
    }
}