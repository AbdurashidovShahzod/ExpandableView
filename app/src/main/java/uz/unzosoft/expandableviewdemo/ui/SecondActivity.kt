package uz.unzosoft.expandableviewdemo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.unzosoft.expandableviewdemo.R
import uz.unzosoft.expandableviewdemo.adapters.MyExpandableAdapter
import uz.unzosoft.expandableviewdemo.adapters.MyExpandableAdapterTechnicals

class SecondActivity : AppCompatActivity() {
    private var listTitle = ArrayList<String>()
    private lateinit var map: HashMap<String, List<String>>
    private lateinit var adapter: MyExpandableAdapterTechnicals


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)


    }
}