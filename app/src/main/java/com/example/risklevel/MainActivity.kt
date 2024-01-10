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
import com.example.risklevel.data.ApiClient
import com.example.risklevel.models.request.LoginRequest
import com.example.risklevel.ui.theme.RiskLevelTheme
import com.example.risklevel.utils.SessionManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {

    private lateinit var apiClient: ApiClient
    private lateinit var sessionManager: SessionManager
    private val TAG: String = "CHECK_RESPONSE"
    private val BASE_URL: String = "http://10.0.2.2:5000/api/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        apiClient = ApiClient()
        sessionManager = SessionManager(this)
        login()
        setContent {
            RiskLevelTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    RiskApp()
                }
            }
        }

    }

    private fun login() {
        apiClient.getApiService().login(LoginRequest(email = "test@mail.com", password = "123123"))
            .enqueue(object : Callback<LoginResponse> {
                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {
                    response.body()!!.token.let {
                        Log.i(TAG, "onResponse: ${it}")
                    }
                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
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