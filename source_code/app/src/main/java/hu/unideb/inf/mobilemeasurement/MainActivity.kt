package hu.unideb.inf.mobilemeasurement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)
        val navView = findViewById<NavigationView>(R.id.navView)
        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        findViewById<DrawerLayout>(R.id.drawerLayout).addDrawerListener(toggle)
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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}