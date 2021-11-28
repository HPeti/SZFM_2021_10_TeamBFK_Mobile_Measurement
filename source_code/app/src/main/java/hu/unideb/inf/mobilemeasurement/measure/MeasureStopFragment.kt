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
import androidx.databinding.DataBindingUtil
import hu.unideb.inf.mobilemeasurement.R
import hu.unideb.inf.mobilemeasurement.databinding.FragmentMeasureStopBinding
import kotlin.math.pow

class MeasureStopFragment : Fragment(), SensorEventListener {
    /** Setup values **/
    private val maxNumberOfMeasures : Int = 3
    private val threshold : Double = 0.02
    private val thresholdNegative : Double = threshold * -1

    /**Sensors**/
    private lateinit var sensorManager: SensorManager
    private var linearAccelerometer: Sensor? = null

    /** Binding values**/
    private lateinit var x_value: TextView
    private lateinit var y_value: TextView
    private lateinit var z_value: TextView
    private lateinit var timeText: TextView
    private lateinit var deltaTimeText: TextView
    private lateinit var xDistanceText: TextView
    private lateinit var completionText: TextView

    /** Measurement values **/
    private var deltaT : Double = 0.0
    private var oldTimeMS : Double = 0.0
    private var xDistance : Double = 0.0
    private var currentNumberOfMeasures : Int = 0
    private var isMeasureRunning : Boolean = false
    private var oldVelocity : Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun setupBinding(binding: FragmentMeasureStopBinding){
        x_value = binding.xText
        y_value = binding.yText
        z_value = binding.zText
        timeText = binding.timeText
        deltaTimeText = binding.deltaTimeText
        xDistanceText = binding.xDistanceText
        completionText = binding.completionTextView

        completionText.text = currentNumberOfMeasures.toString() + " / " + maxNumberOfMeasures
    }

    fun incrementCompletion(){
        currentNumberOfMeasures++
        completionText.text = currentNumberOfMeasures.toString() + " / " + maxNumberOfMeasures
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentMeasureStopBinding>(
            inflater,
            R.layout.fragment_measure_stop,
            container,
            false)

        setupBinding(binding)

        binding.startMeasureButton.setOnClickListener{
            if(currentNumberOfMeasures < maxNumberOfMeasures && !isMeasureRunning){
                setUpSensor()
                isMeasureRunning = true
                incrementCompletion()
            }
        }

        binding.stopMeasureButton.setOnClickListener{
            if(isMeasureRunning){
                sensorManager.unregisterListener(this)
                isMeasureRunning = false
                if(currentNumberOfMeasures == maxNumberOfMeasures){

                }
            }
        }
        return binding.root
    }

    /**Sensor Calcualtions**/
    private fun setUpSensor() {
        sensorManager = activity?.getSystemService(SENSOR_SERVICE) as SensorManager
        //its us not ms! (1ms = 1000 us)
        linearAccelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION).also {
            sensorManager.registerListener(this, it, 20000)
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

                /* s = u * t + 1/2 * a * t^2
                   s = distance
                   u = initial velocity
                   t = time (delta t)
                   a = acceleration
                */
                /* v = u + a * t
                   u = initial velocity
                   a = acceleration
                   t = time (delta t)
                */
                xDistance += (1/2).toDouble() * xVal * (deltaT/1000).pow(2)
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