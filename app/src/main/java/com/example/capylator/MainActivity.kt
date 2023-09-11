package com.example.capylator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception


class MainActivity : AppCompatActivity() {
    lateinit var mathoperation: TextView
    lateinit var btn_0: TextView
    lateinit var btn_1: TextView
    lateinit var btn_2: TextView
    lateinit var btn_3: TextView
    lateinit var btn_4: TextView
    lateinit var btn_5: TextView
    lateinit var btn_6: TextView
    lateinit var btn_7: TextView
    lateinit var btn_8: TextView
    lateinit var btn_9: TextView
    lateinit var plus_btn: TextView
    lateinit var minus_btn: TextView
    lateinit var scobka1_btn: TextView
    lateinit var scobka2_btn: TextView
    lateinit var razdel_btn: TextView
    lateinit var umn_btn: TextView
    lateinit var ac_btn: TextView
    lateinit var ravno_btn: TextView
    lateinit var btn_toch: TextView
    lateinit var btn_back: TextView
    lateinit var result_text: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        mathoperation = findViewById(R.id.mathoperation)
        btn_0 = findViewById(R.id.btn_0)
        btn_1 = findViewById(R.id.btn_1)
        btn_2 = findViewById(R.id.btn_2)
        btn_3 = findViewById(R.id.btn_3)
        btn_4 = findViewById(R.id.btn_4)
        btn_5 = findViewById(R.id.btn_5)
        btn_6 = findViewById(R.id.btn_6)
        btn_7 = findViewById(R.id.btn_7)
        btn_8 = findViewById(R.id.btn_8)
        btn_9 = findViewById(R.id.btn_9)
        plus_btn = findViewById(R.id.plus_btn)
        minus_btn = findViewById(R.id.minus_btn)
        scobka1_btn = findViewById(R.id.scobka1_btn)
        scobka2_btn = findViewById(R.id.scobka2_btn)
        razdel_btn = findViewById(R.id.razdel_btn)
        umn_btn = findViewById(R.id.umn_btn)
        result_text = findViewById(R.id.result_text)
        ac_btn = findViewById(R.id.ac_btn)
        ravno_btn = findViewById(R.id.ravno_btn)
        btn_toch = findViewById(R.id.btn_toch)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       btn_0.setOnClickListener { setTextFields("0") }
        btn_1.setOnClickListener { setTextFields("1") }
        btn_2.setOnClickListener { setTextFields("2") }
        btn_3.setOnClickListener { setTextFields("3") }
        btn_4.setOnClickListener { setTextFields("4") }
        btn_5.setOnClickListener { setTextFields("5") }
        btn_6.setOnClickListener { setTextFields("6") }
        btn_7.setOnClickListener { setTextFields("7") }
        btn_8.setOnClickListener { setTextFields("8") }
        btn_9.setOnClickListener { setTextFields("9") }
        plus_btn.setOnClickListener { setTextFields("+") }
        minus_btn.setOnClickListener { setTextFields("-") }
        scobka1_btn.setOnClickListener { setTextFields("(") }
        scobka2_btn.setOnClickListener { setTextFields(")") }
        razdel_btn.setOnClickListener { setTextFields("/") }
        umn_btn.setOnClickListener { setTextFields("*") }

        ac_btn.setOnClickListener {
            mathoperation.text =  ""
result_text.text = ""
        }

        btn_back.setOnClickListener {
            val str = mathoperation.text.toString()
            if(str.isNotEmpty())
                mathoperation.text = str.substring(0, str.length - 1)

            result_text.text = ""
        }

        ravno_btn.setOnClickListener {
            try {
val ex = ExpressionBuilder(mathoperation.text.toString()).build()
                val result = ex.evaluate()

                val longRes = result.toLong()
                if(result == longRes.toDouble())
                    result_text.text = longRes.toString()
                else
                    result_text.text = result.toString()

            } catch (e:Exception) {
                Log.d("Ашыбка", "сообщение: ${e.message}")

            }
        }
    }
fun setTextFields(str: String) {
    if(result_text.text != "") {
        mathoperation.text = result_text.text
        result_text.text = ""
    }
mathoperation.append(str)

}

}