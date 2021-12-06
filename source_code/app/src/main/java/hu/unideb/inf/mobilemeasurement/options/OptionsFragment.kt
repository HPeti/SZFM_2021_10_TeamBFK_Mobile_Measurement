package hu.unideb.inf.mobilemeasurement.options

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import hu.unideb.inf.mobilemeasurement.R
import hu.unideb.inf.mobilemeasurement.databinding.FragmentOptionsBinding
import android.os.Environment
import android.widget.Toast
import java.io.File


class OptionsFragment : Fragment() {
    lateinit var darkModeSwitch : Switch

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentOptionsBinding>(
            inflater,
            R.layout.fragment_options,
            container,
            false
        )
        darkModeSwitch = binding.switch2

        if(AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES){
            darkModeSwitch.toggle()
        }

        darkModeSwitch.setOnCheckedChangeListener { _, isChecked ->
            Log.i("OptionsFragment", "Listener enter")
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                Log.i("OptionsFragment", "Night mode activated")
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                Log.i("OptionsFragment", "Night mode disabled")
            }
        }

        binding.deleteDataButton.setOnClickListener{
            val path = context?.getExternalFilesDir(null)
            val csvsDirectory = File(path, "measurements")
            if(csvsDirectory.exists()){
                Log.i("OptionsFragment:deleteData", "measurements directory exists")
                if (csvsDirectory.isDirectory()) {
                    val children: Array<String> = csvsDirectory.list()
                    for (i in children.indices) {
                        File(csvsDirectory, children[i]).delete()
                    }
                    csvsDirectory.delete()
                }
                Toast.makeText(activity?.applicationContext, "Adatok törlése megtörtént!", Toast.LENGTH_SHORT).show();
                Log.i("OptionsFragment:deleteData", "Data deletion done!")
            }
            else{
                Toast.makeText(activity?.applicationContext, "Nincs törölhető adat!", Toast.LENGTH_SHORT).show();
                Log.i("OptionsFragment:deleteData", "No data found!")
            }



        }

        binding.modelTextView.setText(android.os.Build.MODEL)
        return binding.root
    }
}