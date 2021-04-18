package com.gullerkilic.storingdata

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.gullerkilic.storingdata.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    lateinit var sharedPreferences : SharedPreferences
    var ageFromDatabase : Int? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPreferences = this.getSharedPreferences("com.gullerkilic.storingdata", MODE_PRIVATE)

        ageFromDatabase = sharedPreferences.getInt("age",0)

        if (ageFromDatabase == 0){
            binding.textView.text = "Your age: "
        }else{
            binding.textView.text = "Your age : $ageFromDatabase"
        }


    }

    fun save (view :  View){

        val myAge = binding.editTextNumber.text.toString().toIntOrNull()

        if (myAge != null){
            binding.textView.text = "Your age : $myAge"
            sharedPreferences.edit().putInt("age",myAge).apply()
        }


    }

    fun delete (view : View){
        ageFromDatabase = sharedPreferences.getInt("age",0)

        if (ageFromDatabase != 0){
            sharedPreferences.edit().remove("age")
            binding.textView.text = "Your age : "
        }

    }
}