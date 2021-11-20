package hu.unideb.inf.mobilemeasurement.database

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import hu.unideb.inf.mobilemeasurement.R
import hu.unideb.inf.mobilemeasurement.databinding.FragmentDatabaseBinding
import java.sql.Connection
import java.sql.Driver
import java.sql.DriverManager
import java.sql.SQLException
import java.util.*

class databaseFragment : Fragment() {

    internal var conn : Connection?= null
    lateinit var editTextUsername : EditText
    lateinit var editTextPassword : EditText
    lateinit var outputText : TextView

    fun startConnection() {
        val connectionProps = Properties()
        connectionProps.put("user", editTextUsername.text)
        connectionProps.put("password", editTextPassword.text)
        try {
            //var myDriver : Driver = oracle.jdbc.driver.OracleDriver()
            //DriverManager.registerDriver(myDriver)
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance()
            conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@oracle.inf.unideb.hu:1521:ora19c",
                connectionProps.getProperty("user"),
                connectionProps.getProperty("password"))
        } catch (ex: SQLException) {
            // handle any errors
            ex.printStackTrace()
        } catch (ex: Exception) {
            // handle any errors
            ex.printStackTrace()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentDatabaseBinding>(
            inflater,
            R.layout.fragment_database,
            container,
            false
        )
        editTextUsername = binding.editTextUsername
        editTextPassword = binding.editTextPassword
        outputText = binding.outputText

        binding.connectButton.setOnClickListener{
            if(editTextUsername.text.isNotEmpty()){
                if(editTextPassword.text.isNotEmpty()) {
                    startConnection()
                    if (conn != null){
                        outputText.text = "Connected to the database!"
                    }
                    else{
                        outputText.text = "Connection failed!"
                    }
                }
                else{
                    //password empty
                }
            }
            else{
                //username empty
            }
        }

        return binding.root
    }

}