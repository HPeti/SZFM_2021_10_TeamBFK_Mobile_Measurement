package hu.unideb.inf.mobilemeasurement.measure

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException
import java.util.*
import kotlin.collections.ArrayList

class MeasureViewModelFactory (
    private val distance : Int,
    private val measure_ID : String,
    private val phone_ID : String,
    private val samplingRate : Int,
    private val orientation : String,
    private val date : Date,
    private val sensorData1 : ArrayList<Float>,
    private val sensorData2 : ArrayList<Float>,
    private val sensorData3 : ArrayList<Float>,
    private val calculatedDistance1 : Double,
    private val calculatedDistance2 : Double,
    private val calculatedDistance3 : Double,

    ) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MeasureViewModel::class.java)){
            return MeasureViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}