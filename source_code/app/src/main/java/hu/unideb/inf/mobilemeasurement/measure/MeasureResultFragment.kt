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
        binding.StartNewButton.setOnClickListener { view ->
            view.findNavController().navigate(MeasureResultFragmentDirections.actionMeasureResultFragmentToMeasureStartFragment())
        }

        setupClass(binding)
        binding.phoneIDTextView.text = "Telefon azonos??t??: " + viewModel.phone_ID.value.toString()
        binding.measurementIDTextView.text = "M??r??s opcion??lis neve: " + viewModel.measure_ID.value.toString()
        binding.etcInfoTextView.text = ("Mintav??telez??s: " + viewModel.sampling_Rate.value.toString()
                + " us, orient??ci??: "+ viewModel.orientation.value.toString())
        binding.expectedDistanceTextView.text = ("M??rt t??vols??g: " + viewModel.distance.value.toString()
                +" cm")
        measure1Value.text = "1. m??r??s eredm??nye: "+ viewModel.calculatedDistance1.value.toString() + " cm"
        measure2Value.text = "2. m??r??s eredm??nye: "+ viewModel.calculatedDistance2.value.toString() + " cm"
        measure3Value.text = "3. m??r??s eredm??nye: "+ viewModel.calculatedDistance3.value.toString() + " cm"
        binding.Date.text = ("D??tum azonos??t??: " + currentDate)

        writeMeasurementToFile()
        writeSensorDatasToFile()

        return binding.root
    }

    private fun convertMeasurementToString(measurementCount : Int,calculatedDistance : Double) : String {
        return (viewModel.phone_ID.value.toString() + ";"
                + currentDate + ";"
                + viewModel.measure_ID.value.toString() + ";"
                + measurementCount.toString() + ";"
                + viewModel.distance.value.toString() + ";"
                + viewModel.sampling_Rate.value.toString() + ";"
                + viewModel.orientation.value.toString() + ";"
                + calculatedDistance.toString())
    }

    private fun writeMeasurementToFile() {
        val path = context?.getExternalFilesDir(null)
        val csvsDirectory = File(path, "measurements")
        csvsDirectory.mkdirs()

        val file = File(csvsDirectory,"measurements.csv")
        Log.i("MeasureResultFragment:CSV", "CSV file path is \'"+file.path.toString()+"\'")
        if(!file.exists()){
            file.appendText("phoneID;date;measureID;sensorData;distance;samplingRate;orientation;calculatedDistance\n")
            Log.i("MeasureResultFragment:CSV", "measurements.csv created, added csv header.")
        }
        file.appendText(
            convertMeasurementToString(1,viewModel.calculatedDistance1.value!!.toDouble()) + "\n"
        )
        file.appendText(
            convertMeasurementToString(2, viewModel.calculatedDistance2.value!!.toDouble()) + "\n"
        )
        file.appendText(
            convertMeasurementToString(3, viewModel.calculatedDistance3.value!!.toDouble()) + "\n"
        )
        Log.i("MeasureResultFragment:CSV", "File exists, appending measurements.csv")
    }

    private fun convertSensorDataToString(sensorDataCount : Int, eventNumber : Int, sensorData: SensorData) : String {
        return (viewModel.phone_ID.value.toString() + ";"
                + currentDate + ";"
                + sensorDataCount.toString() + ";"
                + eventNumber.toString() + ";"
                + sensorData.x_value.toString() + ";"
                + sensorData.y_value.toString() + ";"
                + sensorData.z_value.toString())
    }

    private fun writeSensorDatasToFile(){
        val path = context?.getExternalFilesDir(null)
        val csvsDirectory = File(path, "measurements")
        csvsDirectory.mkdirs()

        val file = File(csvsDirectory,"sensordatas.csv")
        Log.i("MeasureResultFragment:CSV", "CSV file path is \'"+file.path.toString()+"\'")
        if(!file.exists()){
            file.appendText("phoneID;date;sensorData;eventNumber;x;y;z\n")
            Log.i("MeasureResultFragment:CSV", "sensordatas.csv created, added csv header.")
        }
        var eventNumber = 0
        for (item : SensorData in viewModel.sensorData1.value!!.toTypedArray()){
            eventNumber++
            file.appendText(convertSensorDataToString(1,eventNumber,item) + "\n")
        }
        eventNumber = 0
        for (item : SensorData in viewModel.sensorData2.value!!.toTypedArray()){
            eventNumber++
            file.appendText(convertSensorDataToString(2,eventNumber,item) + "\n")
        }
        eventNumber = 0
        for (item : SensorData in viewModel.sensorData3.value!!.toTypedArray()){
            eventNumber++
            file.appendText(convertSensorDataToString(3,eventNumber,item)+ "\n")
        }
        Log.i("MeasureResultFragment:CSV", "File exists, appending sensordatas.csv")
    }

}