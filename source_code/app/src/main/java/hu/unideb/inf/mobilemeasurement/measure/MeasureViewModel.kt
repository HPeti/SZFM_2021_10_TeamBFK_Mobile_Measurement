package hu.unideb.inf.mobilemeasurement.measure

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*
import kotlin.collections.ArrayList

class MeasureViewModel : ViewModel(){

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

    val date : MutableLiveData<Date> by lazy{
        MutableLiveData<Date>()
    }

    val sensorData1 : MutableLiveData<ArrayList<Float>> by lazy {
        MutableLiveData<ArrayList<Float>>()
    }
    val sensorData2 : MutableLiveData<ArrayList<Float>> by lazy {
        MutableLiveData<ArrayList<Float>>()
    }
    val sensorData3 : MutableLiveData<ArrayList<Float>> by lazy {
        MutableLiveData<ArrayList<Float>>()
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

}