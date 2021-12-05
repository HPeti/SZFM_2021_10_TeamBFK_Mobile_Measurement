package hu.unideb.inf.mobilemeasurement.database

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SensorData(val x_value : Float, val y_value : Float, val z_value : Float) : Parcelable {
}