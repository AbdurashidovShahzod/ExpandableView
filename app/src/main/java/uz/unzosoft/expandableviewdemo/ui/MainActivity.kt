package uz.unzosoft.expandableviewdemo.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import uz.unzosoft.expandableviewdemo.R
import uz.unzosoft.expandableviewdemo.adapters.MyExpandableAdapter

class MainActivity : AppCompatActivity() {
    lateinit var map: HashMap<String, List<String>>
    var listTitle = ArrayList<String>()
    lateinit var adapter: MyExpandableAdapter
    var lastPosition = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData()
        adapter = MyExpandableAdapter(listTitle, map)
        expandableListView.setAdapter(adapter)

        expandableListView.setOnChildClickListener { _, _, groupPosition, childPosition, _ ->
            val intent = Intent(this, ResultActivity1::class.java)
            val get = map[listTitle[groupPosition]]?.get(childPosition)
            intent.putExtra("get", get)
//            Toast.makeText(
//                this,
//                map[listTitle[groupPosition]]?.get(childPosition),
//                Toast.LENGTH_SHORT
//            ).show()
            startActivity(intent)
            true
        }


//        expandableListView.setOnGroupCollapseListener {
//            Toast.makeText(this, "Collapse-> ${listTitle[it]}", Toast.LENGTH_SHORT).show()
//
//        }


//        expandableListView.setOnGroupExpandListener {
//            Toast.makeText(this, "Expand-> ${listTitle[it]}", Toast.LENGTH_SHORT).show()
//        }
//        Toast.makeText(this, "$a", Toast.LENGTH_SHORT).show()


//        expandableListView.setOnGroupClickListener { expandableListView, view, i, l ->
//            Toast.makeText(this, "Collapse-> ${listTitle[i]}", Toast.LENGTH_SHORT).show()
//            true
//        }
//

//        expandableListView.setOnGroupExpandListener {
//            if (last != -1 && it != last) {
//                expandableListView.collapseGroup(last)
//            } else {
//                last = it
//            }
//        }


        expandableListView.setOnGroupExpandListener { groupPosition ->
            if (lastPosition != -1 && groupPosition != lastPosition) {
                expandableListView.collapseGroup(lastPosition)
            }
            lastPosition = groupPosition
        }


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
        listTitle.add("Fruits")
        listTitle.add("Flowers")
        listTitle.add("Animals")
        listTitle.add("Birds")
    }

}

