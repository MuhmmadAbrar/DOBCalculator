package com.example.dobcalc

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.time.DayOfWeek
import java.util.Calendar
import java.util.Date

class MainActivity : AppCompatActivity() {

    private var tvSelectedDate:TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDatePicker : Button = findViewById(R.id.btnDatepicker)
        tvSelectedDate = findViewById(R.id.tvSelectedDate)

        btnDatePicker.setOnClickListener{
            clickDatePicker()
        }

    }
    fun clickDatePicker(){

        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(
            this,
            {view,year,month,DayOfMonth->
                Toast.makeText(this, "Year was $year and the date was $day",Toast.LENGTH_LONG).show()
                val SelectedDate = "$DayOfMonth/${month+1}/$year"
                tvSelectedDate?.setText(SelectedDate)
            },year, month, day).show()
    }
}