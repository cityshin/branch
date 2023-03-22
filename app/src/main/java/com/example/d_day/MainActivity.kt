package com.example.d_day

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import java.util.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val start_btn = findViewById<Button>(R.id.start_btn)
        val end_btn = findViewById<Button>(R.id.end_btn)

        var start_date=""
        var end_date=""

        val calendar_start = Calendar.getInstance()
        val calendar_end = Calendar.getInstance()

        start_btn.setOnClickListener{

            val today = GregorianCalendar()
            val year = today.get(Calendar.YEAR)
            val month = today.get(Calendar.MONTH)
            val day = today.get(Calendar.DATE)

            val dlg = DatePickerDialog(this, object : DatePickerDialog.OnDateSetListener{
                override fun onDateSet(p0: DatePicker?, year: Int, month: Int, day: Int) {

                start_date = year.toString() + (month+1).toString() + day.toString()
                    Log.d("day", start_date)

                    calendar_start.set(year, month+1,day)
                }


            },year, month, day)
            dlg.show()

        }

        end_btn.setOnClickListener {
            val today = GregorianCalendar()
            val year = today.get(Calendar.YEAR)
            val month = today.get(Calendar.MONTH)
            val day = today.get(Calendar.DATE)

            val dlg = DatePickerDialog(this, object : DatePickerDialog.OnDateSetListener{
                override fun onDateSet(p0: DatePicker?, year: Int, month: Int, day: Int) {

                    end_date = year.toString() + (month+1).toString() + day.toString()
                    Log.d("day", end_date)

                    calendar_end.set(year, month+1,day)

                    val count =  findViewById<TextView>(R.id.count)

                    val finalDate = TimeUnit.MILLISECONDS.toDays(calendar_end.timeInMillis-calendar_start.timeInMillis)

                    count.setText(finalDate.toString())

                }


            },year, month, day)
            dlg.show()

        }

    }
}