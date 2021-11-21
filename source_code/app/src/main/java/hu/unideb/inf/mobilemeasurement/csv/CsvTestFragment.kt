package hu.unideb.inf.mobilemeasurement.csv

import android.os.Bundle
import android.os.Environment
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import hu.unideb.inf.mobilemeasurement.R
import hu.unideb.inf.mobilemeasurement.databinding.FragmentCsvTestBinding
import java.io.File
import java.io.FileOutputStream
import java.io.FileWriter
import java.nio.charset.Charset

class CsvTestFragment : Fragment() {

    lateinit var editTextInput: EditText
    lateinit var buttonWrite: Button
    lateinit var buttonRead: Button
    lateinit var textviewOutput: TextView
    private val CSV_HEADER = "id;name"

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
        editTextInput = binding.editTextTextInput
        buttonWrite = binding.buttonWrite
        buttonRead = binding.buttonRead
        textviewOutput = binding.textViewOutputCsv

        buttonWrite.setOnClickListener{

            val path = context?.getExternalFilesDir(null)

            val csvsDirectory = File(path, "csvs")
            csvsDirectory.mkdirs()

            val file = File(csvsDirectory,"csv_test_output.csv")

            try {
                file.appendText(CSV_HEADER)
                file.appendText("\n")
                file.appendText("1;Geza\n")
                file.appendText("2;"+editTextInput.text+"\n")
                println("Write CSV successfully!")

            } catch (e: Exception) {
                println("Writing CSV error!")
                e.printStackTrace()
            }
        }

        return binding.root
    }
}