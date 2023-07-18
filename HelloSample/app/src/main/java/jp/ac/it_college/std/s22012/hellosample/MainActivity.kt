package jp.ac.it_college.std.s22012.hellosample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import jp.ac.it_college.std.s22012.hellosample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//ボタンはとってくる
        //val btClick = findViewById<Button>(R.id.btClick)
        val listener = HelloListener()
        binding.btClick.setOnClickListener(listener)
        //btClick.setOnClickListener(listener)
    }

    private inner class HelloListener : View.OnClickListener {
        override fun onClick(v: View?) {
            // val input = binding.etName
           // val output = binding.tvOutput
            val inputStr = binding.etName.text.toString()
            binding.tvOutput.text = "${inputStr}さんこんにちは"
        }

    }

    }