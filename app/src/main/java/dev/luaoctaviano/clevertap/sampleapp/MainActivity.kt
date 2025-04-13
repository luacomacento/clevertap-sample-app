package dev.luaoctaviano.clevertap.sampleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.clevertap.android.sdk.CleverTapAPI
import dev.luaoctaviano.clevertap.sampleapp.ui.home.HomeScreen
import dev.luaoctaviano.clevertap.sampleapp.ui.theme.CleverTapSampleAppTheme

class MainActivity : ComponentActivity() {

    private val cleverTap by lazy {
        CleverTapAPI.getDefaultInstance(applicationContext)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            CleverTapSampleAppTheme {
                HomeScreen {
                    onMainButtonClick()
                }
            }
        }
    }

    private fun onMainButtonClick() {
        val eventProperties = hashMapOf<String, Any>()
        eventProperties["Product ID"] = 1
        eventProperties["Product Image"] = "https://d35fo82fjcw0y8.cloudfront.net/2018/07/26020307/customer-success-clevertap.jpg"
        eventProperties["Product Name"] = "CleverTap"

        val profileUpdate = hashMapOf<String, Any>()
        profileUpdate["Email"] = "clevertap+luaoctaviano@gmail.com"

        cleverTap?.onUserLogin(profileUpdate)
        cleverTap?.pushEvent("Product Viewed", eventProperties)
    }
}
