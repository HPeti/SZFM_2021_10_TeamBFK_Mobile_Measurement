package hu.unideb.inf.mobilemeasurement.measure

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import hu.unideb.inf.mobilemeasurement.R
import hu.unideb.inf.mobilemeasurement.database.SensorData
import hu.unideb.inf.mobilemeasurement.databinding.FragmentMeasureResultBinding
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

class MeasureResultFragment : Fragment() {
    private lateinit var measure1Value : TextView
    private lateinit var measure2Value : TextView
    private lateinit var measure3Value : TextView
    private lateinit var viewModel: MeasureViewModel
    private lateinit var viewModelFactory: MeasureViewModelFactory

    private val phoneID : String = android.os.Build.BRAND+"_"+android.os.Build.MODEL
    private val dateFormatter : SimpleDateFormat= SimpleDateFormat("yyyy_MM_dd_hh_mm_ss", Locale.US);
    private val currentDate = dateFormatter.format(Calendar.getInstance().getTime())

    private fun setupClass(binding : FragmentMeasureResultBinding){
        measure1Value = binding.measure1Value
        measure2Value = binding.measure2Value
        measure3Value = binding.measure3Value
        viewModelFactory = MeasureViewModelFactory(MeasureResultFragmentArgs.fromBundle(requireArguments()).distance,
            MeasureResultFragmentArgs.fromBundle(requireArguments()).measureID,
            MeasureResultFragmentArgs.fromBundle(requireArguments()).phoneID,
            MeasureResultFragmentArgs.fromBundle(requireArguments()).samplingRate,
            MeasureResultFragmentArgs.fromBundle(requireArguments()).orientation,
            MeasureResultFragmentArgs.fromBundle(requireArguments()).sensorData1!!.toCollection(ArrayList<SensorData>()),
            MeasureResultFragmentArgs.fromBundle(requireArguments()).sensorData2!!.toCollection(ArrayList<SensorData>()),
            MeasureResultFragmentArgs.fromBundle(requireArguments()).sensorData3!!.toCollection(ArrayList<SensorData>()),
            MeasureResultFragmentArgs.fromBundle(requireArguments()).calculatedDistance1,
            MeasureResultFragmentArgs.fromBundle(requireArguments()).calculatedDistance2,
            MeasureResultFragmentArgs.fromBundle(requireArguments()).calculatedDistance3
            )
        viewModel = ViewModelProvider(this, viewModelFactory).get(MeasureViewModel::class.java)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentMeasureResultBinding>(
            inflater, R.layout.fragment_measure_result, container, false)

        binding.mainPageButton.setOnClickListener { view ->
            view.findNavController().navigate(MeasureResultFragmentDirections.actionMeasureResultFragmentToHomeFragment())
        }

        setupClass(binding)

        measure1Value.setText(viewModel.phone_ID.value.toString())
        measure2Value.setText(viewModel.measure_ID.value.toString())
        measure3Value.setText(currentDate)
        return binding.root
    }
}