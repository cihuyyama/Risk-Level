package com.example.risklevel

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.risklevel.ui.theme.RiskLevelTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {

    private val BASE_URL: String = "http://10.0.2.2:8080/api/"
    private val TAG: String = "CHECK_RESPONSE"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getAllKontak()
        setContent {
            RiskLevelTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }

    }

    private fun getAllKontak() {
        val api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ServiceTest::class.java)
        api.getAllKontak().enqueue(object : Callback<KontakList>{
            override fun onResponse(call: Call<KontakList>, response: Response<KontakList>) {
                if (response.isSuccessful) {
                    response.body()!!.kontaks.let {
                        for (item in it) {
                            Log.i(TAG, "onResponse: ${item}")
                        }
                    }
                }
            }

            override fun onFailure(call: Call<KontakList>, t: Throwable) {
                Log.i(TAG, "onFailure: ${t.message}")
            }


        })
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RiskLevelTheme {
        Greeting("Android")
    }
}