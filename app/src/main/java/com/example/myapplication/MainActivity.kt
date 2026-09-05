package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                SocialSparksScreen()
            }
        }
    }
}

//The Main screen for the Social Spark App
@Composable
fun SocialSparksScreen() {
    var timeOfDay by remember { mutableStateOf("") }//Contains the time of the Day
    var suggestion by remember { mutableStateOf("") }//Contains suggestions given to the user

    Column(//layout for the screen
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFD6E5))
            .padding(24.dp),
        horizontalAlignment =Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(//Title of the app and how it should look
            text = "Social Sparks",
            color=Color(0xFFD6336C),
            fontSize = 50.sp,
            fontWeight= FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text="Connect & Socialize",
            color=Color.White,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(24.dp))
        OutlinedTextField(//input section that allows the user to enter the time of the day
            value = timeOfDay,
            onValueChange = { timeOfDay = it },
            label = { Text("Enter time of day") },
            placeholder = { Text("morning,mid-morning,afternoon, afternoon snack time, dinner,night") },
            shape = RoundedCornerShape(22.dp),
            modifier = Modifier
                .fillMaxWidth(0.85f),
            colors= OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFFD6336C),
                unfocusedBorderColor = Color(0xFFD6336C),
                focusedLabelColor = Color(0xFFD6336C),
            )
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {//checks what the users input is and generates a suggestion

                Log.d("SocialSparks","User entered:$timeOfDay")//
                suggestion = when (timeOfDay.trim().lowercase()) {
                    "morning" -> "Send a good morning message to a family member."
                    "mid-morning" -> "Reach out to a colleague with a quick Thank you"
                    "afternoon" -> "Share a funny meme or interesting link with a friend."
                    "afternoon snack time"-> "Send a quick thinking of you message"
                    "dinner"-> "Call a friend or relative fo a 5-minute catch-up."
                    "night"-> "Leave a thoughtful comment on a friends post"
                    else -> "Please enter morning,mid-morning, afternoon,afternoon snack time, dinner or night.(use lowercase"
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp),
            colors= ButtonDefaults.buttonColors(
                containerColor=Color(0xFFD6336C)
            )
        ) {
            Text(
                text="Get Suggestions",
                fontSize = 18.sp,
                fontWeight= FontWeight.Medium,
            color=Color.White
            )
        }

        Spacer(modifier = Modifier.height(25.dp))

        Text(
            text = suggestion,
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(20.dp))


        Button(//the reset button, clears out the user input and suggestion
            onClick = {
                timeOfDay = ""
                suggestion = ""
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp),
            colors= ButtonDefaults.buttonColors(
                containerColor = Color(0xFFD6336C)
            ),
            shape = RoundedCornerShape(22.dp),
        ) {
            Text(
                text= "Reset",
                fontSize =18.sp,
                color=Color.White
            )
        }
    }
}