package hu.unideb.inf.mobilemeasurement.measure

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import hu.unideb.inf.mobilemeasurement.R
import hu.unideb.inf.mobilemeasurement.databinding.FragmentMeasureStartBinding
import android.widget.Toast
import hu.unideb.inf.mobilemeasurement.database.SensorData


class MeasureStartFragment : Fragment() {

    private val phoneID : String = android.os.Build.BRAND+"_"+android.os.Build.MODEL

    lateinit var distanceRadioGroup : RadioGroup
    lateinit var samplingRadioGroup: RadioGroup
    lateinit var orientationRadioGroup: RadioGroup
    lateinit var viewModel: MeasureViewModel
    private lateinit var viewModelFactory : MeasureViewModelFactory

    fun setupClass(binding : FragmentMeasureStartBinding){
        //setup binding and viewmodel here
        distanceRadioGroup = binding.distanceRadioGroup
        samplingRadioGroup = binding.samplingRadioGroup
        orientationRadioGroup = binding.orientationRadioGroup

        viewModelFactory = MeasureViewModelFactory(0,
            "",
            "",
            0,
            "",
            arrayListOf<SensorData>(),
            arrayListOf<SensorData>(),
            arrayListOf<SensorData>(),
            0.0,
            0.0,
            0.0)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MeasureViewModel::class.java)
        binding.measureViewModel = viewModel
    }

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

        setupClass(binding)
        binding.phoneIDText.setText(phoneID)

        distanceRadioGroup.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                binding.distance40cm.id -> viewModel.distance.value = 40
                binding.distance1m.id -> viewModel.distance.value = 100
                binding.distance2m.id -> viewModel.distance.value = 200
                binding.distance5m.id -> viewModel.distance.value = 500
            }
        }

        samplingRadioGroup.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId){
                binding.samplingA.id -> viewModel.sampling_Rate.value = 10000
                binding.samplingB.id -> viewModel.sampling_Rate.value = 100000
            }
        }

        orientationRadioGroup.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId){
                binding.verticalButton.id -> viewModel.orientation.value = "vertical"
                binding.horizontalButton.id -> viewModel.orientation.value = "horizontal"
            }
        }

        binding.NextButton.setOnClickListener{ view ->

            if (distanceRadioGroup.checkedRadioButtonId == -1)
            {
                Toast.makeText(activity?.applicationContext, "Nem választotta ki a távolságot", Toast.LENGTH_SHORT).show();
            }
            else if(samplingRadioGroup.checkedRadioButtonId == -1)
            {
                Toast.makeText(activity?.applicationContext, "Nem választotta ki a mintavételezés fajtáját", Toast.LENGTH_SHORT).show();
            }
            else if(orientationRadioGroup.checkedRadioButtonId == -1)
            {
                Toast.makeText(activity?.applicationContext, "Nem választotta ki a telefon orientációját", Toast.LENGTH_SHORT).show();
            }
            else {
                if(binding.measureIDInput.text.isEmpty()){
                    viewModel.measure_ID.value = "no id"
                }
                viewModel.phone_ID.value = phoneID
                Log.i("MeasureStart", viewModel.phone_ID.value.toString())
                view.findNavController()
                    .navigate(MeasureStartFragmentDirections.
                    actionMeasureStartFragmentToMeasureStopFragment(viewModel.distance.value!!.toInt(),
                        viewModel.measure_ID.value.toString(),
                        viewModel.phone_ID.value.toString(),
                        viewModel.sampling_Rate.value!!.toInt(),
                        viewModel.orientation.value.toString()
                    ))
            }
        }

        return binding.root
    }
}