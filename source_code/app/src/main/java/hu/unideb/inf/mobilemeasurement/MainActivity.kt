package hu.unideb.inf.mobilemeasurement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle
    lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)
        val navView = findViewById<NavigationView>(R.id.navView)

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener{
            when(it.itemId){
                R.id.menu_home_item -> Toast.makeText(applicationContext, "Főoldal menüpont kiválasztva", Toast.LENGTH_SHORT).show()
                R.id.menu_measure_item -> Toast.makeText(applicationContext, "Mérés menüpont kiválasztva", Toast.LENGTH_SHORT).show()
                R.id.menu_results_item -> Toast.makeText(applicationContext, "Mérés eredményei menüpont kiválasztva", Toast.LENGTH_SHORT).show()
                R.id.menu_options_item -> Toast.makeText(applicationContext, "Beállítások menüpont kiválasztva", Toast.LENGTH_SHORT).show()
                R.id.menu_info_item -> Toast.makeText(applicationContext, "Információ menüpont kiválasztva", Toast.LENGTH_SHORT).show()
            }
            true
        }
    }
    private fun replaceFragment(fragment: Fragment, title : String){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.commit()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}