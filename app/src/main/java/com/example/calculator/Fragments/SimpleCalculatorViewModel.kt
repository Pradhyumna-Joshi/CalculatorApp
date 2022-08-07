package com.example.calculator.Fragments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import net.objecthunter.exp4j.ExpressionBuilder

class SimpleCalculatorViewModel : ViewModel() {

    var inputText = MutableLiveData<String>()
    val outputText= MutableLiveData<String>()

    fun updateLiveData(string:String){
        if(string.endsWith('+') || string.endsWith('-') || string.endsWith('*') || string.endsWith('/')){
            return
        }
        else{
            val expression =ExpressionBuilder(string).build()
            val result=expression.evaluate()
            val longResult=result.toLong()

            if(result == longResult.toDouble()){

                outputText.value=longResult.toString()
            }
            else{
                outputText.value=result.toString()
            }
        }

    }
}