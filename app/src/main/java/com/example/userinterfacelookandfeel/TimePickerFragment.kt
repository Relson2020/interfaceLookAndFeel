package com.example.userinterfacelookandfeel

import android.app.Dialog
import android.app.TimePickerDialog
import android.icu.util.Calendar
import android.os.Build
import android.os.Bundle
import android.text.format.DateFormat
import android.widget.TimePicker
import androidx.annotation.RequiresApi
import androidx.fragment.app.DialogFragment


class TimePickerFragment : DialogFragment() , TimePickerDialog.OnTimeSetListener {

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val calendarInstance = Calendar.getInstance()
        val hour = calendarInstance.get(Calendar.HOUR_OF_DAY)
        val minute = calendarInstance.get(Calendar.MINUTE)

        return TimePickerDialog(activity,this,hour,minute, DateFormat.is24HourFormat(activity))
    }
    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        MainActivity().setTime(hourOfDay,minute)
    }

}