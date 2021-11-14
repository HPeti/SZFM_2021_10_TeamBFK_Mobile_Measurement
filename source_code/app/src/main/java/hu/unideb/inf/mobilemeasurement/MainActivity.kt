package hu.unideb.inf.mobilemeasurement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.google.android.material.navigation.NavigationView
import hu.unideb.inf.mobilemeasurement.databinding.ActivityMainBinding
import hu.unideb.inf.mobilemeasurement.home.HomeFragment
import hu.unideb.inf.mobilemeasurement.info.InfoFragment
import hu.unideb.inf.mobilemeasurement.measure.MeasureStartFragment
import hu.unideb.inf.mobilemeasurement.options.OptionsFragment
import hu.unideb.inf.mobilemeasurement.results.ResultsFragment

class MainActivity : AppCompatActivity() {

    //lateinit var toggle: ActionBarDrawerToggle
    lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)
        drawerLayout = binding.drawerLayout

        val navController = this.findNavController(R.id.nav_host_fragment)
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)
        NavigationUI.setupWithNavController(binding.navView, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.nav_host_fragment)
        return NavigationUI.navigateUp(navController, drawerLayout)
    }
}