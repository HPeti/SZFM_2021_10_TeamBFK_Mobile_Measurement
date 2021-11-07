package hu.unideb.inf.mobilemeasurement

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.R


import android.widget.RadioGroup
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout


class MeasureFragment : Fragment() {

    lateinit var distanceGroup: RadioGroup
    lateinit var samplingGroup: RadioGroup



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        
        
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var myView = inflater.inflate(R.layout.fragment_measure_start, container, false)
        distanceGroup = myView.findViewById<RadioGroup>(R.id.distance_Radio_Group)

        return myView
    }

}