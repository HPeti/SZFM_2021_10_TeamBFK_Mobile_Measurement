package hu.unideb.inf.mobilemeasurement.measure

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import hu.unideb.inf.mobilemeasurement.database.SensorData
import java.lang.IllegalArgumentException
import java.util.*
import kotlin.collections.ArrayList

class MeasureViewModelFactory (
    private val distance : Int,
    private val measure_ID : String,
    private val phone_ID : String,
    private val samplingRate : Int,
    private val orientation : String,
    private val sensorData1 : ArrayList<SensorData>,
    private val sensorData2 : ArrayList<SensorData>,
    private val sensorData3 : ArrayList<SensorData>,
    private val calculatedDistance1 : Double,
    private val calculatedDistance2 : Double,
    private val calculatedDistance3 : Double,

    ) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MeasureViewModel::class.java)){
            return MeasureViewModel(distance,
                measure_ID,
                phone_ID,
                samplingRate,
                orientation,
                sensorData1,
                sensorData2,
                sensorData3,
                calculatedDistance1,
                calculatedDistance2,
                calculatedDistance3) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}