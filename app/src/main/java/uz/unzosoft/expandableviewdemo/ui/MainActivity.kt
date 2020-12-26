package uz.unzosoft.expandableviewdemo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ExpandableListView
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

//        expandableListView.setOnChildClickListener { _, _, groupPosition, childPosition, _ ->
//            Toast.makeText(
//                this,
//                map[listTitle[groupPosition]]?.get(childPosition),
//                Toast.LENGTH_SHORT
//            ).show()
//            true
//
//        }


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
        val spainList = arrayListOf(
            "Barcelona", "Real Madrid",
            "Atletico Madrid", "Seveliya", "Valencia"
        )
        val englandList = arrayListOf(
            "Man city", "Man united",
            "Liverpool", "Chelsea", "Totenham"
        )
        val italyList = arrayListOf("Milan", "Inter", "Juventus", "Roma", "Jenoa")
        val uzbekList = arrayListOf("Pakxtakor", "Bunyodkor", "Qizilqum", "Nasaf")
        map["Spain"] = spainList
        map["England"] = englandList
        map["Italy"] = italyList
        map["Uzbek"] = uzbekList
        listTitle.add("Spain")
        listTitle.add("England")
        listTitle.add("Italy")
        listTitle.add("Uzbek")
    }

}