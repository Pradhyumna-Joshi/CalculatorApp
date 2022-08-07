package com.example.calculator

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.lang.Exception

import java.lang.Thread.sleep

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        supportActionBar?.hide()

        Thread {
            try{
                sleep(2000)
            }
            catch(e:Exception){
                e.printStackTrace()
            }
            finally{
                val intent=Intent(this,MainActivity::class.java)
                startActivity(intent)
                finish()
            }


        }.start()

    }
}