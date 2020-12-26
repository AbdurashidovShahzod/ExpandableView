package uz.unzosoft.expandableviewdemo.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*
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
        initData()
        adapter = MyExpandableAdapterTechnicals(listTitle, map)
        expandableTechnicalListView.setAdapter(adapter)
        expandableTechnicalListView.setOnChildClickListener { _, _, i, i2, _ ->
            val intent = Intent(this, TechnicalResultActivity::class.java)
            val get = map[listTitle[i]]?.get(i2)
            intent.putExtra("get", get)
            startActivity(intent)
            true
        }
    }


    private fun initData() {
        listTitle.add("Mobiles")
        listTitle.add("Laptops")
        listTitle.add("Computer Accessories")
        listTitle.add("Home Entertainment")
        listTitle.add("TVs by brand")
        listTitle.add("Kitchen appliances")
        val mobilesList =
            arrayListOf("Mi", "Honor", "Realme", "Samsung", "Infinix", "Oppo", "Apple")
        val laptopsList = arrayListOf("Mac", "Dell", "Acer")
        val computerAccessoryList = arrayListOf("Pendrive", "Bag", "Mouse")
        val homeEntertainmentList =
            arrayListOf("Home audion speaker", "Home theatres", "Bluetooth speakers")
        val tvList = arrayListOf("Lg", "Samsung")
        val kitchenList = arrayListOf("Smart fryer", "Microwave")

        map = HashMap()
        map["Mobiles"] = mobilesList
        map["Laptops"] = laptopsList
        map["Computer Accessories"] = computerAccessoryList
        map["Home Entertainment"] = homeEntertainmentList
        map["TVs by brand"] = tvList
        map["Kitchen appliances"] = kitchenList
    }
}