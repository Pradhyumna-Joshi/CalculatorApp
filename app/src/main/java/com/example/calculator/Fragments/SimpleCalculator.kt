package com.example.calculator.Fragments

import android.content.res.Resources
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.calculator.databinding.FragmentSimpleCalculatorBinding
import kotlin.concurrent.thread


class SimpleCalculator : Fragment() {

    private lateinit var viewModel: SimpleCalculatorViewModel
    var binding_: FragmentSimpleCalculatorBinding? = null
    private val binding get() = binding_!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        binding_ = FragmentSimpleCalculatorBinding.inflate(inflater, container, false)
        val view = binding.root
        viewModel = SimpleCalculatorViewModel()
        calculate()
        return view
    }

    private fun calculate() {

        val input = binding.inputText
        input.requestFocus()



        binding.apply {


            inputText.showSoftInputOnFocus = false

            btn0.setOnClickListener {
                input.append("0")
            }
            btn1.setOnClickListener {
                input.append("1")
            }
            btn2.setOnClickListener {
                input.append("2")
            }
            btn3.setOnClickListener {
                input.append("3")
            }
            btn4.setOnClickListener {
                input.append("4")
            }
            btn5.setOnClickListener {
                input.append("5")
            }
            btn6.setOnClickListener {
                input.append("6")
            }
            btn7.setOnClickListener {
                input.append("7")
            }
            btn8.setOnClickListener {
                input.append("8")
            }
            btn9.setOnClickListener {
                input.append("9")
            }
            btnAdd.setOnClickListener {
                input.append("+")
            }
            btnSub.setOnClickListener {
                input.append("-")
            }
            btnMul.setOnClickListener {
                input.append("*")
            }
            btnDiv.setOnClickListener {
                input.append("/")
            }
            btnDot.setOnClickListener {
                input.append(".")
            }
            btnopen.setOnClickListener {
                input.append("(")
            }
            btnclose.setOnClickListener {
                input.append(")")
            }
            btnAC.setOnClickListener {
                input.setText("")
                outputText.text = ""
            }

            thread {
                run {
                    clear.setOnClickListener {
                        val position = inputText.selectionStart


                        val currenttext = inputText.text.toString()
                        if (currenttext.isNotEmpty()) {
                            val text =
                                currenttext.substring(0, position - 1) + currenttext.substring(
                                    position,
                                    currenttext.length)
                            inputText.setText(text)
                            inputText.setSelection(position - 1)
                            outputText.text = ""
                        }


                    }
                }
            }

            inputText.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int,
                ) {
                }

                override fun onTextChanged(
                    s: CharSequence?,
                    start: Int,
                    before: Int,
                    count: Int,
                ) {
                    if (s.toString().isNotEmpty()) {
                        textView.text = inputText.text.toString()
                        inputText.textSize = (pixel2dip(textView.textSize))
                        viewModel.inputText.value = "0" + s.toString()
//                        Toast.makeText(requireContext(),s.toString(),Toast.LENGTH_SHORT).show()
                    }
                }

                override fun afterTextChanged(s: Editable?) {

                }

            })



            btnSubmit.setOnClickListener {

                viewModel.inputText.observe(viewLifecycleOwner, {
//                Toast.makeText(requireContext(),it,Toast.LENGTH_SHORT).show()
                    viewModel.updateLiveData(it)
                })




                viewModel.outputText.observe(viewLifecycleOwner, {
                    outputText.text = it

                })
//                val expression =
//                val result=expression.evaluate()
//                val longResult=result.toLong()
//
//                if(result == longResult.toDouble()){
//
//                    outputText.text=longResult.toString()
//                }
//                else{
//                    outputText.text=result.toString()
//                }
            }


        }


    }

    fun pixel2dip(num: Float): Float {

        val b = num.toInt()
        val c = (b / Resources.getSystem().displayMetrics.scaledDensity).toInt()
        return c.toFloat()

    }
}


