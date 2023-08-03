package jp.ac.it_college.std.s22012.lifecyclesample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import jp.ac.it_college.std.s22012.lifecyclesample.databinding.ActivitySubBinding

class SubActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySubBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("LifeCycleSample", "Sub onCreate() called.")
        super.onCreate(savedInstanceState)
      binding = ActivitySubBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btPrevious.setOnClickListener(::onBackClick)
    }
    public override fun onStart() {
        Log.i("LifeCycleSample", "Sub onStart() called.")
        super.onStart()
    }

    public override fun onRestart() {
        Log.i("LifeCycleSample", "Sub onRestart() called.")
        super.onRestart()
    }

    public override fun onResume() {
        Log.i("LifeCycleSample", "Sub onResume() called.")
        super.onResume()
    }

    public override fun onPause() {
        Log.i("LifeCycleSample", "Sub onPause() called.")
        super.onPause()
    }

    public override fun onStop() {
        Log.i("LifeCycleSample", "Sub onStop() called.")
        super.onStop()
    }
    public override fun onDestroy() {
        Log.i("LifeCycleSample", "Sub onDestroy() called.")
        super.onDestroy()
    }

    private fun onBackClick(view:View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}