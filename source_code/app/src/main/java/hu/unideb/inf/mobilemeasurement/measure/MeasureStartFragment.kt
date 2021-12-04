package hu.unideb.inf.mobilemeasurement.measure

import android.os.Bundle
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


class MeasureStartFragment : Fragment() {

    lateinit var distanceRadioGroup : RadioGroup
    lateinit var samplingRadioGroup: RadioGroup
    lateinit var orientationRadioGroup: RadioGroup
    lateinit var viewModel: MeasureViewModel

    fun setupClass(binding : FragmentMeasureStartBinding){
        //setup binding and viewmodel here
        distanceRadioGroup = binding.distanceRadioGroup
        samplingRadioGroup = binding.samplingRadioGroup
        orientationRadioGroup = binding.orientationRadioGroup
        viewModel = ViewModelProvider(this).get(MeasureViewModel::class.java)
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
                binding.verticalButton.id -> viewModel.sampling_Rate.value = 1
                binding.horizontalButton.id -> viewModel.sampling_Rate.value = 2
            }
        }

        binding.phoneIDText.setText(android.os.Build.MODEL)


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
                view.findNavController()
                    .navigate(MeasureStartFragmentDirections.actionMeasureStartFragmentToMeasureStopFragment())
            }
        }
        return binding.root

        //distanceRadioGroup = myView.findViewById<RadioGroup>(R.id.distance_Radio_Group)
    }
}