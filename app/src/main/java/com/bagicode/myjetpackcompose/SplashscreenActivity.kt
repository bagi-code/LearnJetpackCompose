package com.bagicode.myjetpackcompose

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bagicode.myjetpackcompose.ui.theme.MyJetpackComposeTheme
import android.content.Intent
import android.os.Handler
import android.os.Looper
import androidx.compose.ui.graphics.Color

class SplashscreenActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyJetpackComposeTheme {
                Surface(color = MaterialTheme.colors.background) {
                    SetDesignSplashscreen("Compose")
                }
            }
        }

        Handler(Looper.getMainLooper()).postDelayed(Runnable {
            val mainIntent = Intent(this, SigninActivity::class.java)
            startActivity(mainIntent)
            finish()
        }, 300)
    }
}


@Composable
fun SetDesignSplashscreen(name: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.profile_picture),
            contentDescription = "Icon apps",
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
                .border(1.5.dp, Color.Black, CircleShape)
        )

        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Apps $name",
            color = Color.Black,
            style = MaterialTheme.typography.h5
        )
    }

}

@Preview(
    showSystemUi = true,
    name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun SplashscreenPreview() {
    MyJetpackComposeTheme {
        SetDesignSplashscreen("Compose")
    }
}