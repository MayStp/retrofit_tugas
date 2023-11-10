package com.example.a7nov

import android.R
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a7nov.databinding.ActivityMainBinding
import com.example.a7nov.model.Data
import com.example.a7nov.network.ApiClient
import com.example.recycler_view.heroAdapter
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
                    userList.add(i.title)
                }
                val listAdapter = ArrayAdapter(
                    this@MainActivity,
                    R.layout.simple_list_item_1,
                    userList
                )
                with(binding){
                    rvHero.apply {
                        adapter = heroAdapter(response.body()!!.results)
                        layoutManager = LinearLayoutManager(context)
                        val gridLayoutManager = GridLayoutManager(context, 1)
                        layoutManager = gridLayoutManager
                    }
                }
            }
            override fun onFailure(call: Call<Data>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Koneksi error",
                    Toast.LENGTH_LONG).show()
            }
        })
    }
}
