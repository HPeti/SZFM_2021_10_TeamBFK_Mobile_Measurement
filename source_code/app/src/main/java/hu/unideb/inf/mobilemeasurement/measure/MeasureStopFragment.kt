package hu.unideb.inf.mobilemeasurement.measure

import android.content.Context.SENSOR_SERVICE
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.getSystemService
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import hu.unideb.inf.mobilemeasurement.R
import hu.unideb.inf.mobilemeasurement.databinding.FragmentMeasureStartBinding
import hu.unideb.inf.mobilemeasurement.databinding.FragmentMeasureStopBinding
import java.sql.Timestamp
import kotlin.math.pow

class MeasureStopFragment : Fragment(), SensorEventListener {


    /**Sensors**/
    private lateinit var sensorManager: SensorManager
    private var linearAccelerometer: Sensor? = null
    private lateinit var x_value: TextView
    private lateinit var y_value: TextView
    private lateinit var z_value: TextView
    private lateinit var timeText: TextView
    private lateinit var deltaTimeText: TextView
    private var  deltaT : Double = 0.0
    private var  oldTimeMS : Double = 0.0
    private var xDistance : Double = 0.0
    private val threshold : Double = 0.02
    private val thresholdNegative : Double = threshold * -1
    private lateinit var xDistanceText: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentMeasureStopBinding>(
            inflater,
            R.layout.fragment_measure_stop,
            container,
            false
        )
        setUpSensor()
        x_value = binding.xText
        y_value = binding.yText
        z_value = binding.zText
        timeText = binding.timeText
        deltaTimeText = binding.deltaTimeText
        xDistanceText = binding.xDistanceText
        return binding.root
    }

    /**Sensor Calcualtions**/
    private fun setUpSensor() {
        //sensorManager = this.context?.getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensorManager = activity?.getSystemService(SENSOR_SERVICE) as SensorManager
        //its us not ms! (1ms = 1000 us)
        linearAccelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION).also {
            sensorManager.registerListener(this, it, 10000)
        }
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (event?.sensor?.type == Sensor.TYPE_LINEAR_ACCELERATION) {
            if(oldTimeMS != 0.0){
                var xVal = event.values[0]
                var yVal = event.values[1]
                var zVal = event.values[2]

                if(xVal < threshold && xVal > thresholdNegative){
                    xVal = 0F
                }
                if(yVal < threshold && yVal > thresholdNegative){
                    yVal = 0F
                }
                if(zVal < threshold && zVal > thresholdNegative){
                    zVal = 0F
                }

                x_value.setText("X: " + xVal)
                y_value.setText("Y: " + yVal)
                z_value.setText("Z: " + zVal)

                timeText.setText("Timestamp: " + event.timestamp)

                deltaT = ((event.timestamp / 10000000  ).toDouble() - oldTimeMS)

                deltaTimeText.setText("delta time: "+ deltaT + "ms")

                //xDistance += 1/2 * event.values[1] * ((deltaT/1000) * (deltaT/1000))
                xDistance += 1/2 * xVal * (deltaT/1000).pow(2)
                xDistanceText.setText("X distance: " + xDistance + " cm")
            }
            oldTimeMS =(event.timestamp / 10000000 ).toDouble()
        }

    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
        return
    }

    override fun onDestroy() {
        sensorManager.unregisterListener(this)
        super.onDestroy()
    }
}