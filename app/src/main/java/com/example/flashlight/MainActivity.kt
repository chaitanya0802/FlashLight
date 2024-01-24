//Chaitanya Malshikare
// Codsoft Internship
// Android Developement

package com.example.flashlight

import android.content.Context
import android.hardware.camera2.CameraAccessException
import android.hardware.camera2.CameraManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.widget.ToggleButton

class MainActivity : AppCompatActivity() {

    private var togglebutton1: ToggleButton? = null
    private var cameramanager1: CameraManager? = null
    private var cameraID: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        togglebutton1 = findViewById(R.id.tb1)

        cameramanager1 = getSystemService(Context.CAMERA_SERVICE) as CameraManager
        try {
            cameraID = cameramanager1!!.cameraIdList[0]
        } 
        catch (e: CameraAccessException) {
            e.printStackTrace()
        }
    }

    fun switchFlashLight(view: View?) {
        if (togglebutton1!!.isChecked) {
            try {
                cameramanager1!!.setTorchMode(cameraID!!, true)
                Toast.makeText(this@MainActivity, "Flashlight is turned ON",
                    Toast.LENGTH_SHORT).show()
            }
            catch (e: CameraAccessException) {
                e.printStackTrace()
            }
        }
        else {
            try {
                cameramanager1!!.setTorchMode(cameraID!!, false)
                Toast.makeText(this@MainActivity, "Flashlight is turned OFF",
                    Toast.LENGTH_SHORT).show()
            }
            catch (e: CameraAccessException) {
                e.printStackTrace()
            }
        }
    }


    override fun finish() {
        super.finish()
        try {
            cameramanager1!!.setTorchMode(cameraID!!, false)
            Toast.makeText(this, "Flashlight is turned OFF",
                Toast.LENGTH_SHORT).show()
        }
        catch (e: CameraAccessException) {
            e.printStackTrace()
        }
    }

}