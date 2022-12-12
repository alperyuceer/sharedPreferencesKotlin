package com.alperyuceer.verikaydetme

import android.annotation.SuppressLint
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.alperyuceer.verikaydetme.databinding.ActivityMainBinding


@Suppress("UNUSED_PARAMETER")
class MainActivity : AppCompatActivity() {
    private lateinit var sharedPreferences:SharedPreferences
    private var kayitliYas: Int?=null
    private lateinit var binding: ActivityMainBinding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPreferences = this.getSharedPreferences("com.alperyuceer.verikaydetme", MODE_PRIVATE)
        kayitliYas = sharedPreferences.getInt("kayitli_yas",-1)
        if (kayitliYas==-1){
            binding.textView.text= "Your Age: "
        }else{
            binding.textView.text="Your Age: $kayitliYas"
        }
    }
    @SuppressLint("SetTextI18n")
    fun kaydetmeFonksiyonu(view: View){
        val kullaniciYasi=binding.yasInputText.text.toString().toIntOrNull()
        if(kullaniciYasi!=null){
            binding.textView.text= "Yaşınız: $kullaniciYasi"
            sharedPreferences.edit().putInt("kayitli_yas",kullaniciYasi).apply()
        }

    }
    @SuppressLint("SetTextI18n")
    fun silmeFonksiyonu(view: View){
        kayitliYas=sharedPreferences.getInt("kayitli_yas",-1)
        if(kayitliYas!=-1){
            sharedPreferences.edit().remove("kayitli_yas").apply()
            binding.textView.text="Your Age: "
        }

        //sharedPreferences.edit().remove("kayitli_yas").apply()

    }
}