package hu.unideb.inf.mobilemeasurement.measure

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MeasureStartViewModel : ViewModel(){

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

    val orientation_Data: MutableLiveData<Int> by lazy{
        MutableLiveData<Int>()
    }

    private var _showSnackBarEvent = MutableLiveData<Boolean>()
    val showSnackBar: LiveData<Boolean>
        get() = _showSnackBarEvent

    fun doneShowingSnackBar() {
        _showSnackBarEvent.value = false
    }

}