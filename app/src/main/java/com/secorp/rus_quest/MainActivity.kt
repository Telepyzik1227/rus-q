package com.secorp.rus_quest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import io.ktor.client.*
import io.ktor.client.request.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {    val client = HttpClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


           var button = findViewById<Button>(R.id.button)
            button.setOnClickListener {
                val id = 3
                MainScope().launch(Dispatchers.IO) {
                    val data = client.get<String>("http://192.168.111.164:8080/task/$id"){
                    }
                    withContext(Dispatchers.Main){
                        var zxc = findViewById<TextView>(R.id.zxc)
                        zxc.text = data
                    }
                    Log.d("Simple case ", data)
            }



        }
    }
}
