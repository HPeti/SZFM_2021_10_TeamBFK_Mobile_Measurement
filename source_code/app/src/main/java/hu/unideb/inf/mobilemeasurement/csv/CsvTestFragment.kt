package hu.unideb.inf.mobilemeasurement.csv

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import hu.unideb.inf.mobilemeasurement.R
import hu.unideb.inf.mobilemeasurement.databinding.FragmentCsvTestBinding

class CsvTestFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentCsvTestBinding>(
            inflater,
            R.layout.fragment_csv_test,
            container,
            false
        )


        return binding.root
    }
}