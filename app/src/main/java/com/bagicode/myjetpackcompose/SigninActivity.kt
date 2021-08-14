package com.bagicode.myjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bagicode.myjetpackcompose.ui.theme.MyJetpackComposeTheme

class SigninActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyJetpackComposeTheme {
                Surface(color = MaterialTheme.colors.background) {
                    SetDesignSignscreen()
                }
            }
        }
    }
}

@Composable
fun SetDesignSignscreen() {
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(24.dp),
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

        Spacer(modifier = Modifier.height(24.dp))
        var textUsername by rememberSaveable { mutableStateOf("") }
        TextField(
            modifier = Modifier.fillMaxWidth().fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            value = textUsername,
            onValueChange = {
                textUsername = it
            },
            label = { Text("Username") },
            leadingIcon = {
                IconButton(onClick = { }) {
                    Icon(
                        Icons.Filled.Person,
                        "Icon Username",
                        tint = Color.Black)
                }
            }
        )

        Spacer(modifier = Modifier.height(8.dp))
        var textPassword by rememberSaveable { mutableStateOf("") }
        var passwordVisibility: Boolean by remember { mutableStateOf(false) }
        TextField(
            modifier = Modifier.fillMaxWidth().fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            value = textPassword,
            onValueChange = {
                textPassword = it
            },
            leadingIcon = {
                IconButton(onClick = { }) {
                    Icon(
                        Icons.Filled.Lock,
                        "Icon Password",
                        tint = Color.Black)
                }
            },
            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                val image = if (passwordVisibility)
                    Icons.Filled.Visibility
                else Icons.Filled.VisibilityOff

                IconButton(onClick = {
                    passwordVisibility = !passwordVisibility
                }) {
                    Icon(imageVector  = image, "")
                }
            },
            label = { Text("Password") }
        )

        Spacer(modifier = Modifier.height(24.dp))
        Button(modifier = Modifier.fillMaxWidth().fillMaxWidth(),
            onClick = {  }) {
            Text("Sign In")
        }
    }

}

@Preview(
    showSystemUi = true,
    name = "Light Mode")
@Composable
fun SigninPreview() {
    MyJetpackComposeTheme {
        SetDesignSignscreen()
    }
}