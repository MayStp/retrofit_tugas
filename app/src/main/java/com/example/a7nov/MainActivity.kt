package com.example.a7nov

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.a7nov.databinding.ActivityMainBinding
import com.example.a7nov.model.Data
import com.example.a7nov.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val client = ApiClient.getInstance()
        val response = client.getAllChars()
        val userList = ArrayList<String>()

        response.enqueue(object : Callback<Data> {
            override fun onResponse(call: Call<Data>, response: Response<Data>) {
                for (i in response.body()!!.results) {
                    userList.add(i.name)
                }
                val listAdapter = ArrayAdapter(
                    this@MainActivity,
                    R.layout.simple_list_item_1,
                    userList
                )
                binding.lvNama.adapter = listAdapter
            }
            override fun onFailure(call: Call<Data>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Koneksi error",
                    Toast.LENGTH_LONG).show()
            }
        })
    }
}
