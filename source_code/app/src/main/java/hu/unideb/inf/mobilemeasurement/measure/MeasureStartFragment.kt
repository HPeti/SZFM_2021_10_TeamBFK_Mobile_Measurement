package hu.unideb.inf.mobilemeasurement.measure

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import hu.unideb.inf.mobilemeasurement.R
import hu.unideb.inf.mobilemeasurement.databinding.FragmentHomeBinding
import hu.unideb.inf.mobilemeasurement.databinding.FragmentMeasureStartBinding
import hu.unideb.inf.mobilemeasurement.home.HomeFragmentDirections

class MeasureStartFragment : Fragment() {

    lateinit var distanceRadioGroup : RadioGroup
    lateinit var samplingRadioGroup: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentMeasureStartBinding>(
            inflater,
            R.layout.fragment_measure_start,
            container,
            false
        )
        binding.NextButton.setOnClickListener{ view ->
            view.findNavController().navigate(MeasureStartFragmentDirections.actionMeasureStartFragmentToMeasureStopFragment())

        }
        return binding.root

        //distanceRadioGroup = myView.findViewById<RadioGroup>(R.id.distance_Radio_Group)
    }
}