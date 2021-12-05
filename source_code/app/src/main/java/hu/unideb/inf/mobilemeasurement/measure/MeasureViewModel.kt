package hu.unideb.inf.mobilemeasurement.measure

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import hu.unideb.inf.mobilemeasurement.database.SensorData
import java.util.*
import kotlin.collections.ArrayList

class MeasureViewModel(distance : Int,
                       measure_ID : String,
                       phone_ID : String,
                       sampling_Rate : Int,
                       orientation : String,
                       sensorData1 : ArrayList<SensorData>,
                       sensorData2 : ArrayList<SensorData>,
                       sensorData3 : ArrayList<SensorData>,
                       calculatedDistance1 : Double,
                       calculatedDistance2 : Double,
                       calculatedDistance3 : Double) : ViewModel(){

    val distance: MutableLiveData<Int> by lazy{
        MutableLiveData<Int>()
    }

    val measure_ID: MutableLiveData<String> by lazy{
        MutableLiveData<String>()
    }

    val phone_ID: MutableLiveData<String> by lazy{
        MutableLiveData<String>()
    }

    val sampling_Rate: MutableLiveData<Int> by lazy{
        MutableLiveData<Int>()
    }

    val orientation: MutableLiveData<String> by lazy{
        MutableLiveData<String>()
    }

    val sensorData1 : MutableLiveData<ArrayList<SensorData>> by lazy {
        MutableLiveData<ArrayList<SensorData>>()
    }
    val sensorData2 : MutableLiveData<ArrayList<SensorData>> by lazy {
        MutableLiveData<ArrayList<SensorData>>()
    }
    val sensorData3 : MutableLiveData<ArrayList<SensorData>> by lazy {
        MutableLiveData<ArrayList<SensorData>>()
    }
    val calculatedDistance1 : MutableLiveData<Double> by lazy {
        MutableLiveData<Double>()
    }
    val calculatedDistance2 : MutableLiveData<Double> by lazy {
        MutableLiveData<Double>()
    }
    val calculatedDistance3 : MutableLiveData<Double> by lazy {
        MutableLiveData<Double>()
    }

    init {
        this.distance.value = distance
        this.measure_ID.value = measure_ID
        this.phone_ID.value = phone_ID
        this.sampling_Rate.value = sampling_Rate
        this.orientation.value = orientation
        this.sensorData1.value = sensorData1
        this.sensorData2.value = sensorData2
        this.sensorData3.value = sensorData3
        this.calculatedDistance1.value = calculatedDistance1
        this.calculatedDistance2.value = calculatedDistance2
        this.calculatedDistance3.value = calculatedDistance3
    }
}