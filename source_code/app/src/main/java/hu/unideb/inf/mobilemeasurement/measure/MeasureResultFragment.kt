package hu.unideb.inf.mobilemeasurement.measure

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import hu.unideb.inf.mobilemeasurement.R
import hu.unideb.inf.mobilemeasurement.databinding.FragmentMeasureResultBinding
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class MeasureResultFragment : Fragment() {
    private lateinit var measure1Value : TextView
    private lateinit var measure2Value : TextView
    private lateinit var measure3Value : TextView
    private val phoneID : String = android.os.Build.BRAND+"_"+android.os.Build.MODEL
    private val dateFormatter : SimpleDateFormat= SimpleDateFormat("yyyy_MM_dd_hh_mm_ss", Locale.US);
    private val currentDate = dateFormatter.format(Calendar.getInstance().getTime())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentMeasureResultBinding>(
            inflater, R.layout.fragment_measure_result, container, false)

        binding.mainPageButton.setOnClickListener { view ->
            view.findNavController().navigate(MeasureResultFragmentDirections.actionMeasureResultFragmentToHomeFragment())
        }

        measure1Value = binding.measure1Value
        measure2Value = binding.measure2Value
        measure3Value = binding.measure3Value

        measure1Value.setText(phoneID)
        //measure2Value.setText()
        measure3Value.setText(currentDate)
        return binding.root
    }
}