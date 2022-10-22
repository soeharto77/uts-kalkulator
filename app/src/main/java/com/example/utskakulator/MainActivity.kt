package com.example.utskakulator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edt1 = findViewById<EditText>(R.id.edt_satu)
        val edt2 = findViewById<EditText>(R.id.edt_dua)
        val result = findViewById<TextView>(R.id.tv_result)
        val btnTambah = findViewById<Button>(R.id.btn_tambah)
        val btnKurang = findViewById<Button>(R.id.btn_kurang)
        val btnKali = findViewById<Button>(R.id.btn_kali)
        val btnBagi = findViewById<Button>(R.id.btn_bagi)

        btnTambah.setOnClickListener {

            val a: String = edt1.text.toString()
            val b: String = edt2.text.toString()

            if(edt1.text.isEmpty() && edt2.text.isEmpty()){
                Toast.makeText(applicationContext,"silahkan isi", Toast.LENGTH_SHORT).show()
            } else {
                val c = a.toInt()
                val d = b.toInt()
                val e = c + d
                result.text = e.toString()
            }
        }

        btnKurang.setOnClickListener {
            kurang()
        }

        btnKali.setOnClickListener {

            result.text = kali(edt1.text.toString().toInt(), edt2.text.toString().toInt()).toString()
        }

        btnBagi.setOnClickListener{
            result.text = (getEdt1() / getEdt2()).toString()
        }
    }

    fun kurang() {
        val edt1 = findViewById<EditText>(R.id.edt_satu)
        val edt2 = findViewById<EditText>(R.id.edt_dua)
        val result = findViewById<TextView>(R.id.tv_result)
        if(edt1.text.isEmpty() || edt2.text.isEmpty()){
            Toast.makeText(applicationContext,"silahkan isi", Toast.LENGTH_SHORT).show()
        } else {
            val a: Int = edt1.text.toString().toInt()
            val b: Int = edt2.text.toString().toInt()
            val c: Int = a - b
            result.text = c.toString()
        }
    }

    fun kali(a: Int, b: Int): Int {
        return a * b
    }

    fun getEdt1(): Int {
        val edt1 = findViewById<EditText>(R.id.edt_satu)
        val a: String = edt1.text.toString()
        return a.toInt()
    }

    fun getEdt2(): Int {
        val edt2 = findViewById<EditText>(R.id.edt_dua)
        val b: String = edt2.text.toString()
        return b.toInt()
    }
}