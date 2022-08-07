@file:Suppress("PrivatePropertyName")

package com.example.calculator

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding_: ActivityMainBinding? = null
    private val binding get() = binding_!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding_ = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        this.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

    }


}
