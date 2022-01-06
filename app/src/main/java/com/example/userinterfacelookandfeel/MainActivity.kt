package com.example.userinterfacelookandfeel

import android.icu.util.Calendar
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import com.example.userinterfacelookandfeel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private lateinit var binding: ActivityMainBinding

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // dataBinding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // image Button
        binding.imageButton.setOnClickListener {
            Toast.makeText(this, "Image Button is pressed", Toast.LENGTH_SHORT).show()
        }

        // checkbox
        binding.checkBox.setOnClickListener {
            if (binding.checkBox.isChecked) {
                Toast.makeText(this, "CheckBox is checked", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "CheckBox is not checked", Toast.LENGTH_SHORT).show()
            }
        }

        // radio button
        binding.radioGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.radioMale -> Toast.makeText(
                    applicationContext, "radio Male",
                    Toast.LENGTH_SHORT
                ).show()
                R.id.radioFeMale -> Toast.makeText(
                    applicationContext, "radio Female",
                    Toast.LENGTH_SHORT
                ).show()
                else -> Toast.makeText(
                    applicationContext, "radio other",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        // toggle button
        binding.toggleBtn.addOnButtonCheckedListener { _, checkedId, _ ->
            when (checkedId) {
                R.id.toggleBtn2 -> Toast.makeText(
                    this, "Toggle button 2",
                    Toast.LENGTH_SHORT
                ).show()
                R.id.toggleBtn3 -> Toast.makeText(
                    this, "Toggle button 3",
                    Toast.LENGTH_SHORT
                ).show()
                else -> Toast.makeText(
                    this, "Toggle button 1",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        //spinner
        val spinner = binding.spinner
        val adapter = ArrayAdapter.createFromResource(
            this, R.array.spinner,
            android.R.layout.simple_list_item_1
        ).also {
            it.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
            )
        }
        spinner.adapter = adapter
        spinner.onItemSelectedListener = this


        // set time

        val hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
        val minute = Calendar.getInstance().get(Calendar.MINUTE)
        setTime(hour,minute)

        binding.timePicker.setOnClickListener {
            TimePickerFragment().show(supportFragmentManager,"timePicker")
        }

//        binding.datePickerBtn.setOnClickListener {
//            DatePickerFragment().show(supportFragmentManager,"dataPicker")
//        }
        binding.datePickerBtn.setOnClickListener {

        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        when (position) {
            1 -> Toast.makeText(this, "${parent?.getItemAtPosition(position)}",
                    Toast.LENGTH_SHORT).show()
            2 -> Toast.makeText(this, "${parent?.getItemAtPosition(position)}",
                    Toast.LENGTH_SHORT).show()
            else -> Toast.makeText(
                this,
                "${parent?.getItemAtPosition(position)}",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
    }
    fun setTime(hour:Int , minute : Int){
        val time = "$hour : $minute"
        binding.timeTextView.text = time
    }
}