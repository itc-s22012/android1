package jp.ac.it_college.std.s22012.menusample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import jp.ac.it_college.std.s22012.menusample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val menuList = mutableListOf<jp.ac.it_college.std.s22012.menusample.Menu>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initList(binding.lvMenu)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_options_menu_list, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val result = when(item.itemId){
            R.id.menuListOptionTeishoku -> resetMenu(teishokuList)
            R.id.menuListOptionCurry -> resetMenu(curryList)
            else -> super.onOptionsItemSelected(item)
        }
        return result
    }

    private fun initList(view: RecyclerView) {
        view.adapter = MenuListAdapter(menuList, ::order)
        val layoutManager = LinearLayoutManager(this)
        view.layoutManager = layoutManager
        view.addItemDecoration(DividerItemDecoration(this,layoutManager.orientation))
        }
    private fun order(name: String, price: Int) {
        startActivity(Intent(this,MenuThanksActivity::class.java).apply {
        putExtra("menuName", name)
        putExtra("menuPrice",price)
        })
    }
    private fun resetMenu(list: List<jp.ac.it_college.std.s22012.menusample.Menu>): Boolean {
        menuList.clear()
        menuList.addAll(list)
        binding.lvMenu.adapter?.notifyDataSetChanged()
        return true
    }
    }
