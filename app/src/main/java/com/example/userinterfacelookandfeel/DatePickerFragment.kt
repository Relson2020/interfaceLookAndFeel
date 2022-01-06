package com.example.userinterfacelookandfeel

import android.app.DatePickerDialog
import android.app.Dialog
import android.icu.util.Calendar
import android.os.Build
import android.os.Bundle
import android.widget.DatePicker
import androidx.annotation.RequiresApi
import androidx.fragment.app.DialogFragment

class DatePickerFragment:DialogFragment() , DatePickerDialog.OnDateSetListener {

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val calenderInstance = Calendar.getInstance()
        val year = calenderInstance.get(Calendar.YEAR)
        val month = calenderInstance.get(Calendar.MONTH)
        val day = calenderInstance.get(Calendar.DAY_OF_MONTH)

        return DatePickerDialog(requireActivity(),this,year,month,day)
    }
    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        TODO("Not yet implemented")
    }
}