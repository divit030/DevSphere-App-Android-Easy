package com.namangulati.question_1

import android.os.Bundle
import android.widget.Button      
import android.widget.EditText    
import android.widget.TextView    
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    companion object {
        fun calculateTax(income: Double, taxRate: Double): Pair<Double, Double> {
            // TODO: Implement tax calculation
            var finalincome=0.0;
            var deduct=0.0;
            if(income==0.0)
            {
                return Pair(0.0,0.0);
            }

            if(taxRate==0.0)
            {
             return Pair(0.0,income)
            }

                deduct=taxRate*(0.01)*income;
                finalincome=income-deduct;

            return Pair(deduct, finalincome)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

         val etIncome      =((findViewById<EditText>(R.id.etIncome)).toString()).toDouble();
         val etTaxRate     =((findViewById<EditText>(R.id.etTaxRate)).toString()).toDouble();
         val btnCalculate  =findViewById<Button>(R.id.btnCalculate)
         var tvTaxAmount=0.0
         var tvFinalIncome =0.0

        btnCalculate.setOnClickListener {
            // val income 
            // val rate   
            tvTaxAmount=calculateTax(income = etIncome, taxRate = etTaxRate).first;
            tvFinalIncome=calculateTax(income = etIncome, taxRate = etTaxRate).second;
            println("Calculated tax: $tvTaxAmount , Final Income: $tvFinalIncome");
            // TODO: Call calculateTax and update tvTaxAmount, tvFinalIncome
        }
    }
}