package uz.unzosoft.expandableviewdemo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_technical_result.*
import uz.unzosoft.expandableviewdemo.R

class TechnicalResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_technical_result)
        val extras = intent.extras
        val putString = extras?.getString("get")
        tvTechnical.text = putString
    }
}